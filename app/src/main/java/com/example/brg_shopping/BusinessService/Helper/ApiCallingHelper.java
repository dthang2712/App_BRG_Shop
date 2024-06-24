package com.example.brg_shopping.BusinessService.Helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public final class ApiCallingHelper {
    public static <TRequest, TResponse> TResponse getSingleResultFromAPI(TRequest requestObj, String sendOrderURL, String method) throws Exception {
        TResponse result = null;
        Gson gson = new Gson();
        String requestContent = gson.toJson(requestObj);

        URL url = new URL(sendOrderURL);
        HttpsURLConnection httpURLConnection = (HttpsURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(method);
        httpURLConnection.setRequestProperty("Accept", "text/json");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");

        if (!method.equalsIgnoreCase("GET")) {
            httpURLConnection.setDoOutput(true);
            try (OutputStream os = httpURLConnection.getOutputStream()) {
                byte[] input = requestContent.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
        }

        int statusCode = httpURLConnection.getResponseCode();
        StringBuilder responseContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"))) {
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                responseContent.append(responseLine.trim());
            }
        }

        TResponse data = gson.fromJson(responseContent.toString(), new TypeToken<TResponse>() {
        }.getType());

        if (data != null) {
            result = data;
            if (statusCode != HttpURLConnection.HTTP_OK) {
                throw new Exception(responseContent.toString());
            }
        }

        httpURLConnection.disconnect();
        return result;
    }
}
