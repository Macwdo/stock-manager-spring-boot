package br.com.gordao.service;

import br.com.gordao.entity.Sale;
import br.com.gordao.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {


    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getSaleList() {
        Iterable<Sale> saleIterable = this.saleRepository.findAll();
        return Streamable.of(saleIterable).toList();
    }
}
