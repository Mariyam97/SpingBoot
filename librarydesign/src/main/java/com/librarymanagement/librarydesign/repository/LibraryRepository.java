package com.librarymanagement.librarydesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.librarymanagement.librarydesign.entity.Library;

@Repository
public interface LibraryRepository  extends JpaRepository<Library,Long>{

}
