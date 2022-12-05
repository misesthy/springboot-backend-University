package net.javaguides.springboot.controller;

import net.javaguides.springboot.enties.Etudiant;
import net.javaguides.springboot.enties.Product;
import net.javaguides.springboot.repository.EtudiantRepository;
import net.javaguides.springboot.repository.ProductRepository;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ImportExcelController {
    @Autowired
    private ProductRepository productRepository;
    private EtudiantRepository etudiantRepository;


    @RequestMapping(value = "*", method = RequestMethod.POST)
    public ResponseEntity<List<Product>> importExcelFile(@RequestParam("file") MultipartFile files) throws IOException {
        HttpStatus status = HttpStatus.OK;
        List<Product> productList = new ArrayList<>();

        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(files.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {
                Product product = new Product();

                XSSFRow row = worksheet.getRow(index);
                Integer id = (int) row.getCell(0).getNumericCellValue();

                product.setId(Integer.parseInt(id.toString()));
                product.setProductName(row.getCell(1).getStringCellValue());
                product.setPrice(row.getCell(2).getNumericCellValue());
                product.setCategory(row.getCell(3).getStringCellValue());

                productList.add(product);


            }
        }

        List<Product> response = productRepository.saveAll(productList);

        return new ResponseEntity<>(response, status);
    }

    @RequestMapping(value = "/import-excel", method = RequestMethod.POST)
    public ResponseEntity<List<Etudiant>> importExcelfile(@RequestParam("file") MultipartFile files) throws IOException {
        HttpStatus status = HttpStatus.OK;
        List<Etudiant> etudiantList = new ArrayList<>();

        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(files.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet worksheet = workbook.getSheetAt(4);

        for (int index = 4; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 4) {
                Etudiant etudiant = new Etudiant();

                XSSFRow row = worksheet.getRow(index);
                Long id = (long) row.getCell(4).getColumnIndex();

                etudiant.setId((long) Integer.parseInt(id.toString()));
                etudiant.setMatricule(row.getCell(5).getStringCellValue());
                etudiant.setLastName(row.getCell(6).getStringCellValue());
                etudiant.setFirstName(row.getCell(7).getStringCellValue());
                etudiant.setSex(row.getCell(8).getRawValue());
                etudiant.setDate_of_birth(row.getCell(9).getDateCellValue());
                etudiant.setPlace_of_birth(row.getCell(10).getStringCellValue());
                etudiant.setAcademic_year(String.valueOf(row.getCell(11).getNumericCellValue()));
                etudiant.setLevel_of_study((int) row.getCell(12).getNumericCellValue());
                etudiant.setFaculty(row.getCell(13).getStringCellValue());
                etudiant.setAxe(row.getCell(14).getStringCellValue());


                etudiantList.add(etudiant);


            }
        }

        List<Etudiant> response = etudiantRepository.saveAll(etudiantList);

        return new ResponseEntity<>(response, status);
    }

}


