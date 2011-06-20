f = open("test.txt","w");
while True:
	name=raw_input("name: ").upper();
	if name=="EXIT":
		break;
	identification=raw_input("id: ");
	data = raw_input("data: ");
	print("");
	if len(data)>0:
		f.write("public static final BlockType "+name+" = new BlockType((byte)"+identification+",(byte)"+data+");");
	else:
		f.write("public static final BlockType "+name+" = new BlockType((byte)"+identification+");");
	f.write("\n");
f.close();
