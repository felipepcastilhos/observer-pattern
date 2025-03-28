package br.edu.ucs.projetos.observer;

import java.util.Random;

/**
 * Essa classe simula o sensor que coleta dados e notifica o monitor. É
 * essencial para gerar os dados que os displays irão exibir.
 */
public class EquipamentoDeMonitoramento {

  private Random gerador = new Random();
  private SujeitoObservavel monitorDadosClima;

  private double temperaturaAtual;
  private double umidadeAtual;
  private double pressaoAtual;

  public void coletar() throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      this.temperaturaAtual = this.getNumero(0, 35);
      this.umidadeAtual = this.getNumero(10, 100);
      this.pressaoAtual = this.getNumero(900, 1100);

      monitorDadosClima.dadosMudaram();

      Thread.sleep(3000);
    }
  }

  private double getNumero(double min, double max) {
    return gerador.nextDouble() * (max - min) + min;
  }

  public void setMonitorDadosClima(SujeitoObservavel monitorDadosClima) {
    this.monitorDadosClima = monitorDadosClima;
  }

  public double getTemperaturaAtual() {
    return temperaturaAtual;
  }

  public double getHumidadeAtual() {
    return umidadeAtual;
  }

  public double getPressaoAtual() {
    return pressaoAtual;
  }
}
