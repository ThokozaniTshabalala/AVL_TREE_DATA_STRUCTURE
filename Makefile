SRCDIR=src
BINDIR=bin
JAVAC=/usr/bin/javac
JAVA=/usr/bin/java

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES2=Vaccine.class VaccineArray.class \
	BinaryTreeNode.class BinaryTree.class \
	BTQueueNode.class BTQueue.class \
        AVLTree.class AVLExperiment.class \
        AVLExperimentation.class Randomisation.class
CLASSES=$(CLASSES2:%.class=$(BINDIR)/%.class)


default: $(CLASSES)

run: $(CLASSES)
	$(JAVA) -cp $(BINDIR) AVLExperiment

runExperiment: $(CLASSES)
	java -cp bin Randomisation

clean:
	rm $(BINDIR)/*.class