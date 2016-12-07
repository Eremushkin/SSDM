package com.SSDM.controler.servlet;

import com.SSDM.controler.parser.ExcelParser;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Daniil on 23.11.2016.
 */
public class UploadFileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletFileUpload fileUpload = new ServletFileUpload();

        try {
            FileItemIterator iter = fileUpload.getItemIterator(req);

            while (iter.hasNext()){
                FileItemStream itemStream = iter.next();
                ExcelParser excelParser = new ExcelParser();
                excelParser.parse(itemStream.openStream());
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }
}
