package br.edu.ucs.projetos.observer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Esta classe é uma implementação concreta de Observador, responsável por
 * exibir os dados atuais (temperatura, umidade e pressão). Pode também
 * armazenar os últimos 10 valores lidos.
 */
public class DisplayDeCondicoesAtuais implements Observador {

  private Queue<Double> ultimasTemperaturas = new LinkedList<>();
  private Queue<Double> ultimasUmidades = new LinkedList<>();
  private Queue<Double> ultimasPressoes = new LinkedList<>();

  private static final int MAX_REGISTROS = 10;

  @Override
  public void atualizar(double temperatura, double umidade, double pressao) {
    registrar(ultimasTemperaturas, temperatura);
    registrar(ultimasUmidades, umidade);
    registrar(ultimasPressoes, pressao);
    exibir();
  }

  private void registrar(Queue<Double> fila, double valor) {
    if (fila.size() >= MAX_REGISTROS) {
      fila.poll(); // remove o mais antigo
    }
    fila.offer(valor); // adiciona o novo
  }

  private void exibir() {
    double temperaturaAtual = getUltimo(ultimasTemperaturas);
    double umidadeAtual = getUltimo(ultimasUmidades);
    double pressaoAtual = getUltimo(ultimasPressoes);

    System.out.println("=== Condições Atuais ===");
    System.out.printf("Temperatura: %.2f °C\n", temperaturaAtual);
    System.out.printf("Umidade: %.2f %%\n", umidadeAtual);
    System.out.printf("Pressão: %.2f hPa\n", pressaoAtual);
    System.out.println();
  }

  private double getUltimo(Queue<Double> fila) {
    return fila.peek() != null ? ((LinkedList<Double>) fila).getLast() : 0.0;
  }
}
