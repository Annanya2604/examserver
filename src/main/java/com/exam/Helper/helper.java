package com.exam.Helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVPrinter;
//import org.apache.commons.csv.QuoteMode;

import com.exam.entity.StudentQuiz;

public class helper {
	 public static ByteArrayInputStream tutorialsToCSV(List<StudentQuiz> tutorials) {
		    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

		    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
		        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
		      for (StudentQuiz tutorial : tutorials) {
		        List<String> data = Arrays.asList(
		              String.valueOf(tutorial.getStudentQuizId()),
		              
		              tutorial.getUser().getUsername(),
		              tutorial.getQuiz().getQuizName(),
		              tutorial.getQuiz().getSubject().getSubjectName(),
		              String.valueOf(tutorial.getMarksObtained()),
		              tutorial.getResultStatus()
		              
		            );

		        csvPrinter.printRecord(data);
		      }

		      csvPrinter.flush();
		      return new ByteArrayInputStream(out.toByteArray());
		    } catch (IOException e) {
		      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		    }
		  }
}
