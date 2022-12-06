package net.javaguides.springboot.controller;

import net.javaguides.springboot.enties.Etudiant;
import net.javaguides.springboot.enties.Product;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.EtudiantRepository;
import net.javaguides.springboot.repository.ProductRepository;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@RestController
public class ImportExcelController {
    @Autowired
//    private ProductRepository productRepository;
    private EtudiantRepository etudiantRepository;

    @RequestMapping(value = "/file", method = RequestMethod.POST)
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

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {
                Etudiant etudiant = new Etudiant();

                XSSFRow row = worksheet.getRow(index);
                Long id = (long) row.getCell(0).getColumnIndex();

                etudiant.setId((long) Integer.parseInt(id.toString()));
                etudiant.setMatricule(row.getCell(1).getStringCellValue());
                etudiant.setNoms_prenoms(row.getCell(2).getStringCellValue());
                etudiant.setSexe(row.getCell(4).getRawValue());
                etudiant.setDate_de_naissance(row.getCell(5).getDateCellValue());
                etudiant.setLieu_de_naissance(row.getCell(6).getStringCellValue());
                etudiant.setAnnee_academique(String.valueOf(row.getCell(7).getNumericCellValue()));
                etudiant.setNiveau_etude((int) row.getCell(8).getNumericCellValue());
                etudiant.setFiliere(row.getCell(9).getStringCellValue());
                etudiant.setAxe(row.getCell(10).getStringCellValue());


                etudiantList.add(etudiant);


            }
        }

        List<Etudiant> response = etudiantRepository.saveAll(etudiantList);

        return new ResponseEntity<>(response, status);
    }
 }




