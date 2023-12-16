package com.WebtecFinalProject.Controller;

import com.WebtecFinalProject.Model.Gun;
import com.WebtecFinalProject.Model.Request;
import com.WebtecFinalProject.Model.Soldier;
import com.WebtecFinalProject.Service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.opencsv.CSVWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SearchController {

    @Autowired
    SoldierService soldierService;

    @GetMapping("/search")
    public String search(@RequestParam(name = "militaryNumber", required = false) Integer militaryNumber, Model model) {
        model.addAttribute("allSoldiers", soldierService.getAllSoldiers());

        // Check if militaryNumber is present in the request
        if (militaryNumber != null) {
            Soldier foundSoldier = soldierService.findSoldierByMilitaryNumber(militaryNumber);

            // Check if soldier is found
            if (foundSoldier != null) {
                model.addAttribute("soldierFound", true);
                model.addAttribute("soldier", foundSoldier);

                // Retrieve requests and guns for the soldier
                List<Request> soldierRequests = foundSoldier.getRequests();
                List<Gun> soldierGuns = soldierRequests.stream().map(Request::getGun).collect(Collectors.toList());

                model.addAttribute("soldierRequests", soldierRequests);
                model.addAttribute("soldierGuns", soldierGuns);
            } else {
                model.addAttribute("soldierFound", false);
            }
        } else {
            // Handle the case when militaryNumber is not present in the request
            model.addAttribute("soldierFound", false);
        }

        return "Search";
    }

    @PostMapping("/download/allData")
    public ResponseEntity<byte[]> downloadAllData(@RequestParam(name = "militaryNumber") Integer militaryNumber) {
        System.out.println("Inside downloadAllData method");
        Soldier foundSoldier = null;

        // Check if militaryNumber is present in the request
        if (militaryNumber != null) {
            foundSoldier = soldierService.findSoldierByMilitaryNumber(militaryNumber);
        }

        // Check if soldier is found
        if (foundSoldier != null) {
            // Generate CSV data for Soldier
            byte[] soldierData = generateSoldierDataAsCSV(foundSoldier);

            // Generate CSV data for Request
            List<Request> soldierRequests = foundSoldier.getRequests();
            byte[] requestData = generateRequestDataAsCSV(soldierRequests);

            // Generate CSV data for Gun
            List<Gun> soldierGuns = soldierRequests.stream()
                    .map(Request::getGun)
                    .collect(Collectors.toList());
            byte[] gunData = generateGunDataAsCSV(soldierGuns);

            // Combine data into a single byte array
            byte[] allData = combineByteArrays(soldierData, requestData, gunData);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "all_data.csv"); // Set filename

            System.out.println("Download data generated successfully");
            return new ResponseEntity<>(allData, headers, HttpStatus.OK);
        } else {
            // Soldier not found, handle accordingly (e.g., return an error response)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new byte[0]);
        }
    }

    private byte[] generateSoldierDataAsCSV(Soldier soldier) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8))) {

            // Add header with formatting
            String[] header = {"Rank", "UserName", "MilitaryNumber", "Email"};
            csvWriter.writeNext(getFormattedRow(header));

            // Add data row for the soldier
            String[] row = {
                    soldier.getRank().toString(),
                    soldier.getUsername(),
                    String.valueOf(soldier.getMilitaryNumber()),
                    soldier.getEmail()
            };
            csvWriter.writeNext(row);

            csvWriter.flush();
            return outputStream.toByteArray();
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            return new byte[0];
        }
    }

    private byte[] generateRequestDataAsCSV(List<Request> requests) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8))) {

            // Add header with formatting
            String[] header = {"Gun", "RequestDate"};
            csvWriter.writeNext(getFormattedRow(header));

            // Add data rows for requests
            for (Request request : requests) {
                String[] row = {request.getGun().getModel(), String.valueOf(request.getRequestdate())};
                csvWriter.writeNext(row);
            }

            csvWriter.flush();
            return outputStream.toByteArray();
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            return new byte[0];
        }
    }


    private byte[] generateGunDataAsCSV(List<Gun> guns) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8))) {

            // Add header with formatting
            String[] header = {"Manufacturer", "Model", "GunType"};
            csvWriter.writeNext(getFormattedRow(header));

            // Add data rows for guns
            for (Gun gun : guns) {
                String[] row = {gun.getManufacturer(), gun.getModel(), gun.getGuntype().toString()};
                csvWriter.writeNext(row);
            }

            csvWriter.flush();
            return outputStream.toByteArray();
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            return new byte[0];
        }
    }

    private String[] getFormattedRow(String[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = "\"" + row[i] + "\"";
        }
        return row;
    }


    private byte[] combineByteArrays(byte[]... arrays) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            for (byte[] array : arrays) {
                outputStream.write(array);
            }
            return outputStream.toByteArray();
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            return new byte[0];
        }
    }
}
