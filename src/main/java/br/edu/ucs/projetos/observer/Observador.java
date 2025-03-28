package br.edu.ucs.projetos.observer;

/**
 * Essa é a interface que define o que qualquer classe observadora (display)
 * deve implementar para receber atualizações de dados climáticos.
 * 
 * Esse padrão permite desacoplamento entre quem gera os dados e quem consome,
 * facilitando extensibilidade.
 */
public interface Observador {
  void atualizar(double temperatura, double umidade, double pressao);
}
