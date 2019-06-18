package edu.handong.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import edu.handong.java.utils.FileBrokenException;
import edu.handong.java.utils.ZipReader;

public class Runner {
	
	private String input;
	private String output;
	private boolean help;
	
	public void finalExcute(String[] args) throws IOException{
		Options options = createOptions();
		
		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}
		}
		
		ZipReader.readZIPAndWriteCSV(input, output);
		
	}
	
	private ArrayList<String> option1(ArrayList<String> line) {
		ArrayList<String> printLine = new ArrayList<String>();
		
		
	
		return printLine;
	}
	
	
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);
			
			input = cmd.getOptionValue("i");
			output = cmd.getOptionValue("o");
			help = cmd.hasOption("h");
			
			

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}
	
	
	private Options createOptions() {
		Options options = new Options();

		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set an input file path")
				.hasArg()
				.argName("Input path")
				.required() 
				.build());
		
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set an output file path")
				.hasArg()
				.argName("Output path")
				.required() 
				.build());
		
		options.addOption(Option.builder("h").longOpt("help")
		        .desc("Show a Help page")
		        .build());

		return options;
	}
	
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "File combiner";
		String footer ="";
		formatter.printHelp("Final project", header, options, footer, true);
	}
	
	
}
