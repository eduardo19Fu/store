package com.aglayatech.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aglayatech.store.errorhandler.ObjetoNoEncontradoException;
import com.aglayatech.store.model.Familia;
import com.aglayatech.store.repository.FamiliaRepository;
import com.aglayatech.store.service.IFamiliaService;

@Service
public class FamiliaServiceImpl implements IFamiliaService {

	@Autowired
	private FamiliaRepository repoFamilia;
	
	@Override
	public List<Familia> buscarTodos() {
		return repoFamilia.findAll(Sort.by(Direction.ASC,"idproductofamilia"));
	}

	@Override
	public Familia buscarPorId(Integer idfamilia) {
		Optional<Familia> optional = repoFamilia.findById(idfamilia);
		return optional.orElseThrow(() -> new ObjetoNoEncontradoException(String.valueOf(idfamilia)));
	}

	@Override
	public void guardar(Familia familia) {
		repoFamilia.save(familia);
	}

	@Override
	public void eliminar(Integer idfamilia) {
		repoFamilia.deleteById(idfamilia);
	}

}
