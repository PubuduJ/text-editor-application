# Simple Text Editor Application <img src="asset/editor-logo.png" alt="drawing" width="27px"/>

<hr>

### A simple Java-FX technology based text editor application

This is a simple text editor that can create and edit your text files.
The text files can be saved as regular text files with the **.txt** extension 
as well as encrypted text files with the **.encrypted** extension. 
The saved encrypted text files can be opened by this text editor 
application **only**.

#### The main key features of the simple text editor application as follows,

- It can open any type of plain text file and text files with .encrypted file extension which have already been saved by text editor application.
- It is unique text editor which can open up this **.encrypted** text files.
- It can save both plain text files and encrypted text files.
- It has the text files printing facility.
- It has the cut, copy, past and select all, basic text editing options.

#### Key highlights of the UI
1. **Text editor user interface**<br>
<img src="asset/text-editor.png" alt="text-editor" width="500px"/>

2. **Text editor splash screen**<br>
<img src="asset/splash-screen.png" alt="text-editor" width="300px"/>

3. **Save modal window**<br>
<img src="asset/save-window.png" alt="text-editor" width="500px"/>

4. **About window**<br>
<img src="asset/about-window.png" alt="text-editor" width="250px"/>

## Used Technologies

- Java SE 11
- Apache Maven 3.8.6
- Added dependencies to pom.xml
    - javafx-fxml 18.0.1
    - jfoenix 9.0.1

#### Used Integrated Development Environment
- IntelliJ IDEA

## How to use this repository
This project can be used by cloning the 
project to your local computer or running the project jar file.

#### Clone this repository
1. Clone the project using `git clone https://github.com/PubuduJ/text-editor-application.git` terminal command.
2. Open the `pom.xml` file from **IntelliJ IDEA**, make sure to open this as a project.
3. To run this application execute `mvn javafx:run` goal or create separate maven configuration in **IntelliJ IDEA**.

#### Run JAR file
1. Copy `simple-text-editor.jar` file from the project shade directory.
2. Open terminal from the file copied directory.
3. Execute `java -jar simple-text-editor.jar` command from the terminal.

## Project Version
v1.0.0

## License
Copyright &copy; 2022 [PubuduJ](https://www.linkedin.com/in/pubudujanith94/). All Rights Reserved.<br>
This project is licensed under the [MIT license](LICENSE.txt).