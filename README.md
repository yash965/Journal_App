# 📝 Journal App Backend

This is a **Spring Boot backend project** for a personal **Journal Application**, where users can manage their journal entries securely.  
It provides REST APIs for creating, retrieving, and deleting journal entries, with **Basic Authentication** for access control and **MongoDB** as the database.

---

## 🚀 Features

- 🔐 **Basic Authentication** — simple user authentication for secure access  
- 📘 **CRUD Operations** on Journal Entries:
  - Create a new journal entry  
  - Retrieve all entries  
  - Get an entry by ID  
  - Delete an entry  
- 🗄️ **MongoDB Integration** — all data is stored in MongoDB  
- ⚙️ **RESTful API Design**

---

## 🧩 Tech Stack

| Layer | Technology |
|--------|-------------|
| Backend Framework | Spring Boot |
| Database | MongoDB |
| Security | Spring Security (Basic Auth) |
| Build Tool | Maven |
| Language | Java 17+ |


---

## 🧠 API Endpoints

| Method | Endpoint | Description | Authentication |
|--------|-----------|--------------|----------------|
| `GET` | `/Journal` | Get all journal entries | ✅ Required |
| `POST` | `/Journal` | Create a new journal entry | ✅ Required |
| `GET` | `/Journal/id/{id}` | Get a single journal entry by ID | ✅ Required |
| `DELETE` | `/Journal/id/{id}` | Delete a journal entry | ✅ Required |
| `PUT` | `/Journal/id/{id}` | Update a journal entry | ✅ Required |

