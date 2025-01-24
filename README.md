# Exercício de Programação Orientada a Objetos em Java - Anime Naruto

🎯 **Objetivo**  
O objetivo deste desafio é praticar conceitos de Programação Orientada a Objetos (POO) utilizando o universo do anime Naruto. A ideia é criar classes e interfaces em Java que representem os personagens do anime, demonstrando habilidades em herança, interfaces, e organização de código.

---

💻 **Requisitos**

### Atributos da Classe `Personagem`
- **Nome** (String)
- **Idade** (int)
- **Aldeia** (String)
- **Jutsus** (Array de Strings)
- **Chakra** (int)

### Métodos da Classe `Personagem`
- Um construtor para inicializar os atributos.
- Método para adicionar um novo jutsu ao array de jutsus.
- Método para aumentar o chakra do personagem em uma quantidade específica.
- Método para exibir todas as informações do personagem: nome, idade, aldeia, jutsus e chakra.

### Interface `Ninja`
A interface deve conter os métodos:
- `usarJutsu()`: exibe uma mensagem indicando que o personagem está usando um jutsu.
- `desviar()`: exibe uma mensagem indicando que o personagem está desviando de um ataque.

### Classes Específicas
1️⃣ **`NinjaDeTaijutsu`**
- Extende a classe `Personagem`.
- Implementa a interface `Ninja`.
- Método `usarJutsu()`: indica que o personagem está usando um golpe de Taijutsu.
- Método `desviar()`: indica que o personagem está desviando de um ataque utilizando Taijutsu.

2️⃣ **`NinjaDeNinjutsu`**
- Extende a classe `Personagem`.
- Implementa a interface `Ninja`.
- Método `usarJutsu()`: indica que o personagem está usando um jutsu de Ninjutsu.
- Método `desviar()`: indica que o personagem está desviando de um ataque utilizando Ninjutsu.

3️⃣ **`NinjaDeGenjutsu`**
- Extende a classe `Personagem`.
- Implementa a interface `Ninja`.
- Método `usarJutsu()`: indica que o personagem está usando um jutsu de Genjutsu.
- Método `desviar()`: indica que o personagem está desviando de um ataque utilizando Genjutsu.

---

🛠 **Tecnologias Utilizadas**

- **Java**: Linguagem principal do projeto.
- **JUnit 5**: Framework para criação e execução de testes unitários.
- **Spring Boot**: Framework utilizado para facilitar a construção da aplicação.
- **Springdoc OpenAPI**: tilizado para gerar a documentação Swagger da API, permitindo visualizar e testar os endpoints da API diretamente através de uma interface web.
- **H2 Database**: Banco de dados relacional em memória utilizado para persistir as informações do projeto.

---

🛠 **Instruções para Execução**

1️⃣ **Clone o repositório**
   ```bash
   git clone https://github.com/GabrielSbruzzi/Naruto.git
   ```

---

👨‍💻 **Autor**  
[Gabriel Sbruzzi]  
GitHub: [@GabrielSbruzzi](https://github.com/GabrielSbruzzi)  
LinkedIn: [Gabriel Sbruzzi](https://linkedin.com/in/gabriel-sbruzzi)
``` 
