package com.medicinaFacil.acciones;

import java.util.EventObject;

import javax.faces.event.ActionEvent;

import com.icesoft.faces.component.inputfile.FileInfo;
import com.icesoft.faces.component.inputfile.InputFile;
import com.medicinaFacil.entidades.Archivo;
import com.medicinaFacil.entidades.CentroMedico;


public class AgregarCentroMedico {

	private CentroMedico centroMedico = new CentroMedico();
	private Archivo archivo = null;
	private int fileProgress = 0;
	
	
	public CentroMedico getCentroMedico() {
		return centroMedico;
	}

	public void setCentroMedico(CentroMedico centroMedico) {
		this.centroMedico = centroMedico;
	}

	public int getFileProgress() {
		return fileProgress;
	}

	public void setFileProgress(int fileProgress) {
		this.fileProgress = fileProgress;
	}

	public void uploadFile(ActionEvent event) {
        InputFile inputFile = (InputFile) event.getSource();
        FileInfo fileInfo = inputFile.getFileInfo();
        if (fileInfo.getStatus() == FileInfo.SAVED) {
            archivo = new Archivo(fileInfo);
        }
    }
	
	public void fileUploadProgress(EventObject event) {
        InputFile ifile = (InputFile) event.getSource();
        fileProgress = ifile.getFileInfo().getPercent();
    }
}
