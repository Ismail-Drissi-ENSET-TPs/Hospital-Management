# Activité Pratique N°2 - ORM JPA Hibernate Spring Data

## 🔄 Création du Projet
1. Utiliser **Spring Initializer** avec les dépendances suivantes :
    - Spring Web
    - Spring Data JPA
    - H2 Database
    - Lombok

2. Configurer le fichier `application.properties` pour la base H2 :

```properties
spring.datasource.url=jdbc:h2:mem:hospital
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

## 🔧 Développement

### 1. Création de l'entité `Patient`
```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date dateNaissance;
    private boolean malade;
    private int score;
}
```

### 2. Création du Repository
```java
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNomContains(String keyword);
}
```

### 3. Opérations CRUD
- **Ajouter un patient**
- **Consulter tous les patients**
- **Consulter un patient par ID**
- **Chercher des patients par nom**
- **Mettre à jour un patient**
- **Supprimer un patient**

## 🔄 Migration vers MySQL
1. Installer Docker et exécuter la commande suivante pour lancer un conteneur MySQL :

```bash
docker container run --rm -d \
  -p 3306:3306 \
  --name mysql-db \
  -e MYSQL_ALLOW_EMPTY_PASSWORD=true \
  -e MYSQL_DATABASE=hospital \
  mysql:latest
```

2. Modifier le fichier `application.properties` :
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.jpa.hibernate.ddl-auto=update
```

## 🎨 Étapes Avancées
- Implémenter les entités supplémentaires : `Medecin`, `RendezVous`, `Consultation`, `Users`, et `Roles`.
- Suivre les exemples présentés dans les vidéos complémentaires.

## 📅 Commandes Utiles
- **Vérifier si le conteneur MySQL est actif** :
```bash
docker ps
```
- **Accéder à MySQL dans le conteneur** :
```bash
docker exec -it mysql-db mysql -u root
```
- **Lister les bases de données** :
```sql
SHOW DATABASES;
```

---

Ce projet permet de comprendre les bases de l'ORM avec Spring Data JPA et sentir l'utilité d'un ORM lors de la migration de la base de donnée H2 vers MySQL.