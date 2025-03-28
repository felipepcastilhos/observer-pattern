package br.edu.ucs.projetos.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Essa classe será o sujeito concreto (Observable). Ela implementa a interface
 * SujeitoObservavel e armazena os observadores. Sempre que os dados mudam, ela
 * notifica todos os observadores registrados.
 */
public class MonitorDeDadosDoClima implements SujeitoObservavel {

  private List<Observador> observadores;
  private double temperatura;
  private double umidade;
  private double pressao;
  private EquipamentoDeMonitoramento equipamento;

  public MonitorDeDadosDoClima(EquipamentoDeMonitoramento equipamento) {
    this.equipamento = equipamento;
    this.equipamento.setMonitorDadosClima(this); // vínculo com o sensor
    this.observadores = new ArrayList<>();
  }

  @Override
  public void registraObservador(Observador o) {
    observadores.add(o);
  }

  @Override
  public void removeObservador(Observador o) {
    // observadores.remove(o);

    int i = observadores.indexOf(o);

    if (i > 0) {
      observadores.remove(i);
    }
  }

  @Override
  public void notificaObservadores() {
    for (Observador o : this.observadores) {
      o.atualizar(this.temperatura, this.umidade, this.pressao); // implementar atualizar() ???
    }
  }

  @Override
  public void dadosMudaram() {
    this.temperatura = equipamento.getTemperaturaAtual();
    this.umidade = equipamento.getHumidadeAtual();
    this.pressao = equipamento.getPressaoAtual();
    notificaObservadores();
  }
}
