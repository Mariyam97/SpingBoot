package com.librarymanagement.librarydesign.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagement.librarydesign.entity.Library;
import com.librarymanagement.librarydesign.repository.LibraryRepository;
import com.librarymanagement.librarydesign.service.LibraryCreateService;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService {
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Override
	public String addSingleLibrary(Library library) {
		libraryRepository.save(library);
		libraryRepository.flush();
		return "Library saved";
		}
	
	@Override
	public String addAllLibraries(List<Library> libraries) {
		libraryRepository.saveAll(libraries);
		libraryRepository.flush();
		return "All Libraries are saved";
		}

	@Override
	public Library addLibrarywithSavedAndFlush(Library library) {
		return libraryRepository.saveAndFlush(library);
	}
	
}
