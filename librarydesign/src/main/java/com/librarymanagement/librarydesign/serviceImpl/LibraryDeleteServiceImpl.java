package com.librarymanagement.librarydesign.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagement.librarydesign.entity.Library;
import com.librarymanagement.librarydesign.repository.LibraryRepository;
import com.librarymanagement.librarydesign.service.LibraryDeleteService;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService {
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Override
	public String deleteSingleLibrary(Library library) {
		libraryRepository.delete(library);
		
		return "Library Deleted: " +   library;
		}

	
	@Override
	public String pruneTable() {
		libraryRepository.deleteAll();
		return "prune -complete(Delete table)";
	}
	
	@Override
	public String deleteAllThese(List<Library> libraries) {
		libraryRepository.deleteAll(libraries);
		return " ALL Library Deleted:";
	}
	
	@Override
	public String deleteAllInBatch() {
		libraryRepository.deleteAllInBatch();
		return " Deleted All in Batch Completed ";
	}
	
	@Override
	public String deleteLibraryById(Long id) {
		libraryRepository.deleteById(id);
		return "These Libraryis Deleted: " +   id;
		
	}
	
	@Override
	public String deleteAllTheseInBatch(List<Library> libraries) {
		libraryRepository.deleteInBatch(libraries);
		return " ALL Library Deleted in batch mode";
	}
}
