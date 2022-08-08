package com.course.consumingrest.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.course.consumingrest.model.ApiResult;
import com.course.consumingrest.model.Haber;
import com.course.consumingrest.model.Tag;
@Service
public class HaberServiceImp implements HaberService{
	public static final String URL = "https://api.collectapi.com/news/getNews?country=tr&tag=";
	public static final String API_KEY = "apikey 47cl609MP43dkrsEkfU6hF:5ewbzG4QyjWUlI02BZE7sx";
	public static final String API_KEY_HEADER = "authorization";
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public List<Haber> getAll() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(API_KEY_HEADER, API_KEY);
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		HttpEntity<ApiResult> result = restTemplate.exchange(URL + Tag.GENERAL.getTag(), HttpMethod.GET, entity, ApiResult.class);
		return result.getBody().getResult();
	}
	@Override
	public List<Haber> getByTag(Tag tag) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(API_KEY_HEADER, API_KEY);
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		HttpEntity<ApiResult> result = restTemplate.exchange(URL + tag.getTag(), HttpMethod.GET, entity, ApiResult.class);
		return result.getBody().getResult();
	}
}