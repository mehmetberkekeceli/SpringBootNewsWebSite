package com.course.consumingrest.service;
import java.util.List;
import com.course.consumingrest.model.Haber;
import com.course.consumingrest.model.Tag;
public interface HaberService {
	List<Haber> getAll();
	List<Haber> getByTag(Tag tag);
}