Here's a manual on how to install the JDK (Java Development Kit) on a Windows machine and add it to the system's environment variables:

### Step 1: Download the JDK

1. Visit the Oracle JDK download page: [Oracle JDK Download](https://www.oracle.com/java/technologies/downloads/#jdk22-windows). => x64 Installer
2. Accept the license agreement.
3. Download the JDK installer for Windows.

### Step 2: Install the JDK

1. Run the downloaded JDK installer (`.exe` file).
2. Follow the installation wizard instructions.
3. Choose a directory for installation (e.g., `C:\Program Files\Java\jdk-21`).
4. Complete the installation process.

### Step 3: Set JAVA_HOME Environment Variable

1. Right-click on "This PC" or "My Computer" and select "Properties".
2. Click on "Advanced system settings" on the left-hand side.
3. In the System Properties window, click on the "Environment Variables..." button.
4. Under the "System variables" section, click "New" to add a new environment variable.
5. Set the Variable Name to `JAVA_HOME`.
6. Set the Variable Value to the JDK installation directory path (e.g., `C:\Program Files\Java\jdk-11`).
   ![image](https://github.com/rishrcc/JavaSelenium/assets/151720969/8d37f136-c4d1-4418-89a5-714f22c74ed3)
7. Click "OK" to save the environment variable.

### Step 4: Update Path Environment Variable

1. In the Environment Variables window, under the "System variables" section, find the `Path` variable and select it.
2. Click "Edit..." to edit the Path variable.
3. Click "New" to add a new entry.
4. Add `%JAVA_HOME%\bin` to the list of paths. This allows Windows to find the `java`, `javac`, and other JDK executables.
5. Click "OK" to save the changes.

### Step 5: Verify JDK Installation

1. Open Command Prompt (cmd.exe).
2. Type `java -version` and press Enter.
3. Verify that the installed JDK version is displayed.

Congratulations! You have successfully installed the JDK on your Windows machine and added it to the system's environment variables. You can now develop and run Java applications on your computer.

---

Here's a manual on how to install Apache Maven on a Windows machine and add it to the system's environment variables:

### Step 1: Download Apache Maven

1. Visit the Apache Maven download page: [Apache Maven Download](https://maven.apache.org/download.cgi). => apache-maven-3.9.6-bin.zip
2. Under "Files," download the latest version of Apache Maven

### Step 2: Extract Maven Archive

1. Once the download is complete, locate the downloaded ZIP file
2. Right-click on the ZIP file and select "Extract All...".
3. Choose a destination folder for the extracted Maven files (e.g., `C:\Program Files\Apache\`).
4. Click "Extract" to extract the contents of the ZIP file.

### Step 3: Set Up Maven Environment Variables

1. Right-click on "This PC" or "My Computer" and select "Properties".
2. Click on "Advanced system settings" on the left-hand side.
3. In the System Properties window, click on the "Environment Variables..." button.
4. Under the "System variables" section, click "New" to add a new environment variable.
5. Set the Variable Name to `MAVEN_HOME`.
6. Set the Variable Value to the Maven installation directory path (e.g., `C:\Program Files\Apache\apache-maven-3.8.4`).
7. Click "OK" to save the environment variable.

### Step 4: Update Path Environment Variable

1. In the Environment Variables window, under the "System variables" section, find the `Path` variable and select it.
2. Click "Edit..." to edit the Path variable.
3. Click "New" to add a new entry.
4. Add `%MAVEN_HOME%\bin` to the list of paths. This allows Windows to find the Maven executables.
5. Click "OK" to save the changes.

### Step 5: Verify Maven Installation

1. Open Command Prompt (cmd.exe).
2. Type `mvn -v` and press Enter.
3. Verify that Maven is installed and the version is displayed.

Congratulations! You have successfully installed Apache Maven on your Windows machine and added it to the system's environment variables. You can now use Maven to manage your Java projects and dependencies.
