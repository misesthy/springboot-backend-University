package net.javaguides.springboot.controller;

import net.javaguides.springboot.enties.CreditFieldresponse;
import net.javaguides.springboot.enties.Etudiant;
import net.javaguides.springboot.enties.Etudiantresponse;
import net.javaguides.springboot.repository.EtudiantRepository;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
public class ImportExcelController {
    @Autowired
//    private ProductRepository productRepository;
    private EtudiantRepository etudiantRepository;

    @RequestMapping(value = "api/file", method = RequestMethod.POST)
    @CrossOrigin("*")
    public ResponseEntity<List<Etudiant>> importExcelFile(@RequestParam("file") MultipartFile files) throws IOException {
        HttpStatus status = HttpStatus.OK;
        List<Etudiant> etudiantList = new ArrayList<>();

        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(files.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet worksheet = workbook.getSheetAt(0);

        List<Etudiant> response = etudiantRepository.saveAll(etudiantList);

        String annee = worksheet.getRow(5).getCell(8).getStringCellValue();
        System.out.println(annee);

        Integer niveau_etude = (int) worksheet.getRow(3).getCell(8).getNumericCellValue();
        System.out.println(niveau_etude);

        String axe = worksheet.getRow(7).getCell(7).getStringCellValue();
        System.out.println(axe);

        for (int index = 11; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {
                Etudiant etudiant = new Etudiant();

                XSSFRow row = worksheet.getRow(index);
//                Long id = (long) row.getCell(0).getColumnIndex();

                String matricule = row.getCell(1).getStringCellValue();
                System.out.println(matricule);
                
                String noms = row.getCell(3).getStringCellValue();
                System.out.println(noms);

                Double moyenne = row.getCell(155).getNumericCellValue();
                System.out.println(moyenne);

                Double credit_acquis =  row.getCell(157).getNumericCellValue();
                System.out.println(credit_acquis);

                String decision = row.getCell(159).getStringCellValue();
                System.out.println(decision);

                etudiant.setMatricule(matricule);
                etudiant.setNoms(noms);
                etudiant.setMoyenne(moyenne);
                etudiant.setCredit_acquis(credit_acquis);
                etudiant.setDecision(decision);
                /*etudiant.setSexe(row.getCell(4).getRawValue());*/
                /*etudiant.setDate_de_naissance(row.getCell(5).getDateCellValue());*/
                /*etudiant.setLieu_de_naissance(row.getCell(6).getStringCellValue());*/
//                etudiant.setFiliere(row.getCell(9).getStringCellValue());
                etudiant.setAnnee_academique(annee);
                etudiant.setNiveau_etude(niveau_etude);
                etudiant.setAxe(axe);


                etudiantList.add(etudiant);
            }
        }

        return new ResponseEntity<>(etudiantRepository.saveAll(etudiantList), status);
    }

    @RequestMapping(value = "api/etudiants", method = RequestMethod.GET)
    @CrossOrigin("*")
    public ResponseEntity<List<Etudiant>> getAllEtudiants(@RequestParam("orderBy") String orderBy,@RequestParam("direction") String direction, @RequestParam("decision") String decision) throws IOException {
        HttpStatus status = HttpStatus.OK;
        List<Etudiant> etudiantList = new ArrayList<>();

        Sort.Direction directionOfSort = Sort.Direction.DESC;

        if(direction.equals("ASC")){
            directionOfSort = Sort.Direction.ASC;
        }else{
            directionOfSort = Sort.Direction.DESC;
        }

        if(!decision.isEmpty()){
            etudiantList =   etudiantRepository.findMoyenneOrderByDecision(decision);
        }else{
            etudiantList = etudiantRepository.findAll(Sort.by(directionOfSort, orderBy));
        }

        return new ResponseEntity<>(etudiantList, status);
    }

    @RequestMapping(value = "api/etudiant_soutenir", method = RequestMethod.GET)
    @CrossOrigin("*")
    public ResponseEntity<List<Etudiant>> getInEtudiant(@RequestParam("credit_acquis") Integer credit_acquis, @RequestParam("annee_etude") String annee_etude, @RequestParam("niveau_etude") Integer niveau_etude) throws IOException {
//    public ResponseEntity<List<Etudiant>> getInEtudiant(@RequestParam("orderBy") String orderBy, @RequestParam("credit_acquis") Integer credit_acquis) throws IOException {
        HttpStatus status = HttpStatus.OK;
        List<Etudiant> etudiantList = new ArrayList<>();

        if(credit_acquis == 30 ){
            etudiantList =   etudiantRepository.findByCredit(credit_acquis, annee_etude, niveau_etude);
        }

        return new ResponseEntity<>(etudiantList, status);
    }

    @RequestMapping(value = "api/etudiant_Niveau_Superieur", method = RequestMethod.GET)
    @CrossOrigin("*")
    public ResponseEntity<List<Etudiant>> getSupEtudiant(@RequestParam("credit_acquis") Integer credit_acquis) throws IOException {

        HttpStatus status = HttpStatus.OK;
        List<Etudiant> etudiantList = new ArrayList<>();

        etudiantList = etudiantRepository.findAll();


        return new ResponseEntity<>(etudiantList, status);
    }

    @RequestMapping(value = "api/etudiants", method = RequestMethod.DELETE)
    @CrossOrigin("*")
    public ResponseEntity<Map<String,String>>deleteAllEtudiants(){

        HttpStatus status = HttpStatus.OK;

        Map<String,String> response = new HashMap<String, String>();

        response.put("message","Supprimé avec succès");

        etudiantRepository.deleteAll();
        return new ResponseEntity<>(response,status);

    }

    @RequestMapping(value = "api/etudiantsByLevel", method = RequestMethod.GET)
    @CrossOrigin("*")
    public ResponseEntity<List<Etudiantresponse>> getInEtudiantByLevel() throws IOException {
        HttpStatus status = HttpStatus.OK;
        List<Etudiant> etudiantList = new ArrayList<>();
        List<Etudiant> etudiantListCopy = new ArrayList<>();
        ArrayList<Etudiantresponse> etudiantsResponse = new ArrayList<Etudiantresponse>();

        etudiantList = etudiantRepository.findAll();
        for (Etudiant etudiant : etudiantList) {

            if(findInEtudiants(etudiant.getNoms(),etudiantListCopy) != null){
                continue;
            }

            for (Etudiant etudiant2 : etudiantList) {
                if (etudiant.getNoms().equals( etudiant2.getNoms())) {
                    CreditFieldresponse creditFieldresponse = new CreditFieldresponse(etudiant2.getAnnee_academique(),
                            etudiant2.getNiveau_etude(), etudiant2.getCredit_acquis(), etudiant2.getMoyenne());
                    Etudiantresponse etudiantResponse = new Etudiantresponse();
                    etudiantResponse.setId(etudiant2.getId());
                    etudiantResponse.setNoms(etudiant2.getNoms());
                    etudiantResponse.setAxe(etudiant2.getAxe());
                    etudiantResponse.setMatricule(etudiant2.getMatricule());
//                    etudiantResponse.setMoyenne(etudiant2.getMoyenne());
                    etudiantResponse.addArray_credits(creditFieldresponse);
//                    System.out.println(etudiant.getNoms());


                    if(etudiantsResponse.size() != 0){
                        int index = indexOfEtudiant(etudiantsResponse, etudiantResponse);
                        if ( index != -1) {
                            System.out.println(index);
                            etudiantsResponse.get(index).addArray_credits(creditFieldresponse);
                        } else {
                            etudiantsResponse.add(etudiantResponse);
                        }
                    }else{
                        etudiantsResponse.add(etudiantResponse);
                    }

                    // responseObjects.add(responseObjects);
                }
            }


            etudiantListCopy.add(etudiant);
        }

        Collections.sort(etudiantsResponse, Comparator.comparing(Etudiantresponse::getNoms)
                .thenComparing(Etudiantresponse::getNoms)
                .thenComparing(Etudiantresponse::getNoms));

//        Collections.sort(etudiantsResponse, (etudiant1, etudiant2) -> etudiant1.getNoms() > etudiant2.getNoms());

        return new ResponseEntity<>(etudiantsResponse, status);
    }

    @RequestMapping(value = "api/etudiantsByLevelNoSort", method = RequestMethod.GET)
    @CrossOrigin("*")
    public ResponseEntity<List<Etudiantresponse>> getInEtudiantByLevelNoSort() throws IOException {
        HttpStatus status = HttpStatus.OK;
        List<Etudiant> etudiantList = new ArrayList<>();
        List<Etudiant> etudiantListCopy = new ArrayList<>();
        ArrayList<Etudiantresponse> etudiantsResponse = new ArrayList<Etudiantresponse>();

        etudiantList = etudiantRepository.findAll();
        for (Etudiant etudiant : etudiantList) {

            if(findInEtudiants(etudiant.getNoms(),etudiantListCopy) != null){
                continue;
            }

            for (Etudiant etudiant2 : etudiantList) {
                if (etudiant.getNoms().equals( etudiant2.getNoms())) {
                    CreditFieldresponse creditFieldresponse = new CreditFieldresponse(etudiant2.getAnnee_academique(),
                            etudiant2.getNiveau_etude(), etudiant2.getCredit_acquis(), etudiant2.getMoyenne());
                    Etudiantresponse etudiantResponse = new Etudiantresponse();
                    etudiantResponse.setId(etudiant2.getId());
                    etudiantResponse.setNoms(etudiant2.getNoms());
                    etudiantResponse.setAxe(etudiant2.getAxe());
                    etudiantResponse.setMatricule(etudiant2.getMatricule());
                    etudiantResponse.setMoyenne(etudiant2.getMoyenne());
                    etudiantResponse.addArray_credits(creditFieldresponse);
//                    System.out.println(etudiant.getNoms());


                    if(etudiantsResponse.size() != 0){
                        int index = indexOfEtudiant(etudiantsResponse, etudiantResponse);
                        if ( index != -1) {
                            System.out.println(index);
                            etudiantsResponse.get(index).addArray_credits(creditFieldresponse);
                        } else {
                            etudiantsResponse.add(etudiantResponse);
                        }
                    }else{
                        etudiantsResponse.add(etudiantResponse);
                    }

                    // responseObjects.add(responseObjects);
                }
            }


            etudiantListCopy.add(etudiant);
        }
        return new ResponseEntity<>(etudiantsResponse, status);
    }

    int indexOfEtudiant(ArrayList<Etudiantresponse> etudiantsResponse, Etudiantresponse etudiantResponse) {
        for (int i = 0; i < etudiantsResponse.size(); i++) {
            if (etudiantsResponse.get(i).getNoms().equals( etudiantResponse.getNoms())) {
                return i;
            }
        }
        return -1;
    }


    public Etudiant findInEtudiants(
            String noms, List<Etudiant> etudiants) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getNoms().equals(noms)) {
                return etudiant;
            }
        }
        return null;
    }


    @RequestMapping(value = "api/etudiant_annee", method = RequestMethod.GET)
    @CrossOrigin("*")
    public ResponseEntity<List<Etudiant>> getAnnee() throws IOException {

        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(etudiantRepository.findByAnnee(), status);
    }


    @RequestMapping(value = "api/etudiant_niveau", method = RequestMethod.GET)
    @CrossOrigin("*")
    public ResponseEntity<List<Etudiant>> getNiveau() throws IOException {

        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(etudiantRepository.findByNiveau(), status);
    }


 }




