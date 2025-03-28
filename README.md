# Projeto: Observer Pattern - Estação Meteorológica

Este projeto foi desenvolvido como parte da disciplina **Projeto e Arquitetura de Software** da **Universidade de Caxias do Sul (UCS)**. O objetivo foi aplicar o **padrão de projeto Observer** em um sistema de monitoramento climático, de forma simples e didática.

## 🚀 Tecnologias Utilizadas

- Java 17
- Maven
- VSCode

---

## 📂 Estrutura do Projeto

```
observer-pattern/
├── src/
│   ├── main/
│   │   ├── java/
│   │       └── br/edu/ucs/projetos/
│   │           ├── App.java
│   │           ├── EquipamentoDeMonitoramento.java
│   │           ├── MonitorDeDadosDoClima.java
│   │           ├── SujeitoObservavel.java
│   │           ├── Observador.java
│   │           ├── DisplayDeCondicoesAtuais.java
│   │           └── DisplayEstatistico.java
│
├── pom.xml
```

---

## 🌬️ Contexto do Projeto

A ideia do projeto é simular uma estação meteorológica que coleta dados de temperatura, umidade e pressão atmosférica. Esses dados são repassados a "displays" que se comportam como **observadores**.

### Classes principais:

- `EquipamentoDeMonitoramento` — Simula a coleta de dados do clima
- `MonitorDeDadosDoClima` — Sujeito Observável concreto
- `SujeitoObservavel` — Interface do sujeito (publisher)
- `Observador` — Interface dos observadores (subscribers)
- `DisplayDeCondicoesAtuais` — Exibe os dados atuais e os últimos 10 valores
- `DisplayEstatistico` — Exibe média, máxima e mínima das últimas 10 medições

---

## 🔹 Interface de Apresentação

A exibição dos dados foi feita via **console (System.out.println)**, o que atende à definição de interface de apresentação para fins didáticos. A adicição de botões para conectar/desconectar os observadores poderia ser implementada com `Swing`, utilizando `JButton` e `JFrame` em versões futuras.

---

## 🔄 Como Executar

1. Clone o repositório
   ```bash
   git clone https://github.com/seu-usuario/observer-pattern.git
   cd observer-pattern
   ```
2. Certifique-se de que você tem instalado:

- Java JDK 17 ou superior
- Apache Maven (mvn -v deve funcionar no terminal)
- (Opcional) VSCode com a extensão "Extension Pack for Java"

3. Abra o projeto no VSCode
4. Execute a aplicação no terminal Use o seguinte comando no terminal dentro da raiz do projeto:
   ```bash
   mvn clean compile exec:java -Dexec.mainClass="br.edu.ucs.projetos.App"
   ```

## 💡 Observações:

- Se o comando mvn não for reconhecido, instale o Maven com:

  ```bash
  sudo apt update
  sudo apt install maven

  ```

- Certifique-se de estar executando o comando dentro da pasta correta (onde está o pom.xml).
- A execução da aplicação será feita via terminal e os resultados aparecerão diretamente no console.

---

## 🔍 Comparativo com o `java.util.Observer` e `Observable`

Na API do Java (antes de ser marcada como deprecated), o padrão Observer era representado pelas classes:

- `java.util.Observable` (classe base que fornece métodos como `addObserver`, `notifyObservers`)
- `java.util.Observer` (interface com o método `update(Observable o, Object arg)`)

### Para adaptar nosso projeto a essa API:

1. `MonitorDeDadosDoClima` deveria **estender** a classe `Observable` ao invés de implementar a interface `SujeitoObservavel`.
2. `DisplayDeCondicoesAtuais` e `DisplayEstatistico` deveriam **implementar** a interface `Observer`, sobrescrevendo o método `update()`.
3. Os métodos `registraObservador`, `removeObservador` e `notificaObservadores` seriam substituídos por `addObserver()`, `deleteObserver()` e `notifyObservers()`.
4. Os dados poderiam ser passados através do segundo parâmetro de `update(Observable o, Object arg)`, ou o observador poderia acessar diretamente os getters do sujeito.

**Exemplo:**

```java
public class DisplayCondicoesAtuais implements Observer {
    public void update(Observable o, Object arg) {
        MonitorDeDadosDoClima mdc = (MonitorDeDadosDoClima) o;
        // acessar dados via getters
    }
}
```

Contudo, por boas práticas e maior flexibilidade, hoje é comum usar implementações manuais do padrão, como neste projeto, ou bibliotecas como RxJava, EventBus etc.

---

## 👉 Conclusão

O projeto atendeu todos os requisitos funcionais propostos, e demonstrou de forma clara e modular a aplicação do padrão Observer. Pode ser facilmente expandido com GUI em Swing ou JavaFX.

---

## 🌐 Autores

- **Grupo Observer 1 do AVA**
- Curso de Análise e Desenvolvimento de Sistemas (UCS)
- Disciplina: Projeto e Arquitetura de Software
