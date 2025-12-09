package com.teslait.template.bill.infrastructure.outbound.adapter;

import com.teslait.template.stadistic.domain.model.Agency;
import com.teslait.template.stadistic.domain.model.Product;
import com.teslait.template.stadistic.domain.model.StadisticAll;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
@Slf4j
public class StatisticsGrouper {

    private static final String Y_CHARACTER = "Y";

    public static List<Product> groupByProduct
            (List<StadisticAll> lista) {
        final Map<String, List<StadisticAll>> groupProductListStatistics =
                lista.stream().collect(
                        Collectors.groupingBy(groupA -> groupA.getProduct()));
      final List<Product> paraSucursal = new ArrayList<>();
      for(final Map.Entry<String, List<StadisticAll>> entryAR
              : groupProductListStatistics.entrySet()) {
          final Map<LocalDate, List<StadisticAll>> groupSubDateListStatistics =
                  converterTreeMap(
                        entryAR.getValue().stream()
                                .collect(
                                Collectors.groupingBy(
                                groupP -> LocalDate.parse(groupP.getDate()
                                  ),
                                TreeMap::new,
                                Collectors.toList())));
          for(final Map.Entry<LocalDate, List<StadisticAll>> entrySub
                  : groupSubDateListStatistics.entrySet()) {
              Product product = new Product();
              product.setProduct(entryAR.getKey());
              product.setDate(entrySub.getValue().get(0).getDate());
              product.setBatch(String.valueOf(entrySub.getValue().size()));
              final Long groupedStatiscticsNoBill = entrySub.getValue()
                      .stream()
                      .filter(statistics ->{
                  return
                          Y_CHARACTER
                                  .equals(statistics.getBillIndicator());
              }).count();
              product.setBatchResponse(String.valueOf(groupedStatiscticsNoBill));
              paraSucursal.add(product);
          }
      }
      return paraSucursal;
    }
    private static <K, V> Map<K, V> converterTreeMap(Map<K, V> map) {
        return new TreeMap<>(map);
    }
    public static List<Agency> groupByAgency(List<StadisticAll> lista) {

        final Map<String, List<StadisticAll>> groupSucursalListStatistics =
                lista.stream().collect(Collectors.groupingBy(groupA -> groupA.getAgency()));
        final List<Agency> agencys = new ArrayList<>();
        for(final Map.Entry<String, List<StadisticAll>> entryAR : groupSucursalListStatistics.entrySet()) {
            final Map<String, List<StadisticAll>> groupSubProducListStatistics =
                    entryAR.getValue().stream().collect(Collectors.groupingBy(groupP -> groupP.getProduct()));
            for(final Map.Entry<String, List<StadisticAll>> entrySub : groupSubProducListStatistics.entrySet()) {
                Agency agency = new Agency();
                agency.setAgency(entryAR.getKey());
                agency.setProduct(entrySub.getKey());
                agency.setBatch(String.valueOf(entrySub.getValue().size()));
                final Long groupedStatiscticsNoBill = entrySub.getValue().stream().filter(statistics ->{
                    return Y_CHARACTER.equals(statistics.getBillIndicator());
                }).count();
                agency.setBatchResponse(String.valueOf(groupedStatiscticsNoBill));
                agencys.add(agency);
            }
        }
        return agencys;
    }
}
