# 🔒 **File Hider Tool** 🔐

Welcome to the **File Hider Tool**! This Java-based tool is designed to securely hide and unhide files on your local device. It works through a command-line interface, ensuring ease of use with a secure authentication system. Perfect for anyone looking to keep their sensitive files safe and hidden!

---

## 🚀 **Features**

- **🛡️ Authentication**: Secure email-based authentication using the Sun Mail API to ensure only authorized users can access the tool.
- **📁 File Hiding**: Choose any file from your local device and hide it from prying eyes.
- **🔍 Show Hidden Files**: View a list of all hidden files in the system.
- **🔓 Unhide Files**: Select any hidden file by its ID and restore it to your local device.

---

## 🛠️ **Tech Stack**

- **Java**: Core programming language for backend functionality.
- **Maven**: Dependency management for seamless project builds.
- **JDBC (Java Database Connectivity)**: Used to interact with the SQL database for file metadata storage.
- **SQL**: Stores information related to hidden files and user authentication.
- **Sun Mail API**: Handles secure authentication through email.

---

## 💻 **How to Use**

1. **Authentication** 🔑  
   - When you run the program, you'll first authenticate via email using the **Sun Mail API**.
   - You’ll need to enter your email credentials for secure login. Only authorized users can proceed further.

2. **Hide Files** 📂  
   - After successful authentication, you’ll be prompted to select files from your local device.
   - Choose the files you want to hide and confirm the action. They will be securely hidden and no longer visible on your device.

3. **Show Hidden Files** 👀  
   - To view the files you’ve hidden, use the **Show Hidden Files** option.
   - A list of hidden files will be displayed, showing their unique IDs.

4. **Unhide Files** 🔓  
   - Select a file by its ID from the list of hidden files.
   - Once you confirm, the file will be restored and visible on your local device.

---


## 📦 **Installation**

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/StayLearner/File_Hider-JAVA_Project.git
   ```

2. **Import the Project in IntelliJ IDEA**:
   - Open **IntelliJ IDEA**.
   - Select **File > Open** and navigate to the project directory you just cloned.
   - Select the folder and open it.

3. **Build the Project**:
   - If you're using **Maven** to manage dependencies, IntelliJ will automatically detect the `pom.xml` file.
   - Click on **Maven** in the right sidebar and click **Refresh** to ensure all dependencies are resolved.

4. **Run the Project**:
   - In **IntelliJ IDEA**, find the main class (likely the class with the `main()` method).
   - Right-click on the file and select **Run 'Main'** (or just click the green triangle near the main class).
   - Follow the on-screen prompts to authenticate and manage your hidden files.

---

## 💻 **Running the Project in IntelliJ IDEA**

Once the project is open and built in IntelliJ IDEA, running it is as simple as following these steps:

1. Open the **Main class** (the class with the `public static void main(String[] args)` method).
2. Click the green **Run** button (the triangle icon) or use the shortcut **Shift + F10**.
3. The program will start, and you’ll be prompted for email authentication and file hiding/unhiding actions.

---


## 🔒 **Security Considerations**

- **Secure Authentication**: The Sun Mail API ensures that only users with valid email credentials can hide or unhide files, adding a layer of security.
- **Data Privacy**: Hidden files are stored securely in your local environment, and their metadata is managed in the SQL database.

---

## ⚙️ **Future Improvements**

- 🗂️ **Multiple File Support**: Extend the tool to handle multiple files at once for more efficient file management.

---

## 🧑‍💻 **Contributing**

Feel free to contribute to the project! Whether it’s adding a feature or fixing bugs, pull requests are always welcome.  
Please make sure to follow the standard contribution guidelines.

---

## 📞 **Contact**

If you have any questions or suggestions, feel free to reach out:

- **Email**: [rohanghosh078@gmail.com]  
- **GitHub**: [a-AvgLearner](https://github.com/StayLearner)

---

🔐 Stay safe, keep your files secure, and happy coding! 🚀

---

