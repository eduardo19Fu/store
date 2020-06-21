package com.aglayatech.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aglayatech.store.model.NotaCredito;
import com.aglayatech.store.repository.NotaCreditoRepository;
import com.aglayatech.store.service.INotaCreditoService;

@Service
public class NotaCreditoServiceImpl implements INotaCreditoService {
	
	@Autowired
	private NotaCreditoRepository repoNota;
	
	@Override
	public List<NotaCredito> buscarTodos() {
		return repoNota.findAll(Sort.by(Direction.ASC, "idnota"));
	}

	@Override
	public NotaCredito buscarPorId(Integer idnota) {
		Optional<NotaCredito> optional = repoNota.findById(idnota);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public void guardar(NotaCredito notaCredito) {
		repoNota.save(notaCredito);
	}

	@Override
	public void eliminar(Integer idnotas) {
		repoNota.deleteById(idnotas);
	}

}
