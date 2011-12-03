package com.medicinaFacil.entidades;

import java.io.File;

import com.icesoft.faces.component.inputfile.FileInfo;

public class Archivo {

	private FileInfo fileInfo;
	private File file;

	public Archivo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
		this.file = fileInfo.getFile();
	}

	public FileInfo getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
