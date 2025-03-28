package br.edu.ucs.projetos.observer;

/**
 * Interface que define o contrato que qualquer sujeito (observable) deve seguir
 * para permitir o registro, remoção e notificação de observadores.
 */
public interface SujeitoObservavel {
  void registraObservador(Observador o);

  void removeObservador(Observador o);

  void notificaObservadores();

  void dadosMudaram(); // Gatilho para notificação (pode ser omitido se preferir acionar direto)
}
