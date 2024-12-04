package com.gamifyverse.gamifyapi;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.GsonBuilder;

public class Test {
    public static class ResponseData {
        int id;
        long timestamp;
        int userId;
        String userName;
        String userDob;
        Map<String, Object> vitals;
        Map<String, Object> diagnosis;
        Map<String, Object> doctor;
        Map<String, Object> meta;
    }
    public static class Response {
        int page;
        int per_page;
        int total;
        int total_pages;
        List<ResponseData> data;
    }
    public static HttpRequest configureConnection(int currentPage) throws URISyntaxException {
        return HttpRequest.newBuilder(new URI(String.format("https://jsonmock.hackerrank.com/api/medical_records?page=%d", currentPage))).method("GET", HttpRequest.BodyPublishers.noBody()).build();
    }
    
    public static String getResponse(HttpRequest request) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() >= 200 && response.statusCode() <= 299) {
            return response.body();
        }
        return "";
    }

    public static Response parseResponse(String response) {
        if (response == null || response.isEmpty()) return null;
        return new GsonBuilder().create().fromJson(response, Response.class);
    }
    
    public static List<ResponseData> loadData() throws URISyntaxException, IOException, InterruptedException {
        int currentPage = 1;
        List<ResponseData> responseList = new ArrayList();
        Response resp = null;
        while ((resp = parseResponse(getResponse(configureConnection(currentPage)))) != null && currentPage <= resp.total_pages) {
            responseList.addAll(resp.data);
            currentPage++;
        }
        return responseList;
    }

    /*
     * Complete the 'healthCheckup' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER lowerlimit
     *  2. INTEGER upperlimit
     * API URL: https://jsonmock.hackerrank.com/api/medical_records?page={page_no}
     */

    public static int healthCheckup(int lowerlimit, int upperlimit) {
        try {
			List<ResponseData> data = loadData();
            return ((Long)data.stream().filter(d -> {
            	System.out.println(d.vitals.toString());
                Integer bloodPressureDiastole = (Integer)d.vitals.get("bloodPressureDiastole");
                return bloodPressureDiastole >= lowerlimit && bloodPressureDiastole <= upperlimit;
            }).count()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return 0;
    }
    
    public static void main(String[] args) {
		System.out.println(healthCheckup(120, 160));
	}
}
