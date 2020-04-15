package com.bhavana.jasper.main;

import com.bhavana.jasper.controller.HttpClient;
import com.bhavana.jasper.data.EmployeeData;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * pdf Report Generator.
 * 
 * @author Bhavana Vadodariya
 */
public class Reporter {
    /**
     * 
     * @param args
     * @throws Exception 
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("reports/report.jrxml");
        ArrayList<EmployeeData> eList = new ArrayList<EmployeeData>();
        
        HttpClient obj = new HttpClient();

        try {
            System.out.println("Testing 1 - Send Http GET request");
            eList = obj.sendGet();

//            System.out.println("Testing 2 - Send Http POST request");
//            obj.sendPost();
        } finally {
            obj.close();
        }

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(eList);

        Map parameters = new HashMap();

        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "reports/Report.pdf");
    }
}
