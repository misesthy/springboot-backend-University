package net.javaguides.springboot.controller;

import net.javaguides.springboot.enties.Etudiant;
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

        Integer niveau_etude = (int) worksheet.getRow(3).getCell(7).getRowIndex();
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

    @RequestMapping(value = "api/etudiants", method = RequestMethod.GET)
    @CrossOrigin("*")
    public ResponseEntity<List<Etudiant>> getInEtudiant(@RequestParam("orderBy") String orderBy, @RequestParam("credit_acquis") Integer credit_acquis) throws IOException {
        HttpStatus status = HttpStatus.OK;
        List<Etudiant> etudiantList = new ArrayList<>();

        if(credit_acquis == 30 ){
            etudiantList =   etudiantRepository.findAll();
        }

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

//    private static final String DIRECTORY = "C:/PDF";
//    private static final String DEFAULT_FILE_NAME = "java-tutorial.pdf";
//
//    @Autowired
//    private ServletContext servletContext;

    // http://localhost:8080/download1?fileName=abc.zip
    // Using ResponseEntity<InputStreamResource>
//    @RequestMapping("/download1")
//    public ResponseEntity<InputStreamResource> downloadFile1(
//            @RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName) throws IOException {
//
//        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
//        System.out.println("fileName: " + fileName);
//        System.out.println("mediaType: " + mediaType);
//
//        File file = new File(DIRECTORY + "/" + fileName);
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//
//        return ResponseEntity.ok()
//                // Content-Disposition
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
//                // Content-Type
//                .contentType(mediaType)
//                // Contet-Length
//                .contentLength(file.length()) //
//                .body(resource);
//    }

 }




