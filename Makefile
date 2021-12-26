default:
	javac -d . \
	source/Pessoas/Pessoa.java \
	source/Menu/Phases/Phase.java \
	source/Menu/Phases/Phase1.java \
	source/Menu/Phases/Phase2.java \
	source/Menu/Phases/Phase3.java \
	source/Menu/ShowMenu.java \
	source/Menu/Interpreter.java \
	source/Main.java
clean:
	rm bin/*.class
app:
	java bin.Main
# Esta linha é necessario pois ao adicionar argumentos extra na make
# Não queremos que eles sejam executados
%:
	@: