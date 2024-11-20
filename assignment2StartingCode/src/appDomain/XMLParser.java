package appDomain;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import exceptions.EmptyQueueException;
import implementations.MyQueue;
import implementations.MyStack;
import utilities.Iterator;

public class XMLParser {
	private MyQueue<String> errorQueue;
    private MyQueue<String> extrasQueue;
    private MyStack<String> stack;
    
    public XMLParser() {
    	errorQueue = new MyQueue<String>();
    	extrasQueue = new MyQueue<String>();
    	stack = new MyStack<String>();
    }
    
    @SuppressWarnings("resource")
	public void parse(String filePath) throws EmptyQueueException {

    	try {
    		BufferedReader bfReader = new BufferedReader(new FileReader(filePath));
    		String line = bfReader.readLine();
    	    while (line != null){
    			String tag = extractTagName(line);
    			System.out.println(tag);

    			if(isOpeningTag(tag)) {
    				stack.push(tag);
    			}
    			else if(isClosingTag(tag)) {
    				if(stack.isEmpty()) {
    					errorQueue.enqueue(tag);
    				}else if(stack.peek().equals(tag)) {
    					stack.pop();
    				}else if(!errorQueue.isEmpty() && errorQueue.peek().equals(tag)){
    					//ignore the error
    					errorQueue.dequeue();
    				}else {
    					//search to match the opening tag in the stack
    					boolean isFound = stack.contains(tag);
    					
    					//loop to find the matched opening tag
    					if(isFound) {
    						while(!stack.isEmpty() && !stack.peek().equals(tag)) {
    							errorQueue.enqueue(stack.pop());
    					}
    						if (!stack.isEmpty()) {
    	                            stack.pop();
    	                        }
    						
    					}else {
    						  extrasQueue.enqueue(tag);
    					}
    			
    				}
		
    			}
    			line = bfReader.readLine();
    		}
    	}catch (IOException e){
    		e.printStackTrace();
    	}
    }
    
    
    public void reportError() throws EmptyQueueException {
    	while(!stack.isEmpty()) {
    		errorQueue.enqueue(stack.pop());
    	}
    	while(!errorQueue.isEmpty()|| !extrasQueue.isEmpty()) {
    		  if (!errorQueue.isEmpty() && extrasQueue.isEmpty()) {
    	            // Only errorQueue has elements
    	            System.out.println("Error: " + errorQueue.dequeue());
    	        } else if (errorQueue.isEmpty() && !extrasQueue.isEmpty()) {
    	            // Only extrasQueue has elements
    	            System.out.println("Extra: " + extrasQueue.dequeue());
    	        }else {
    	        	String tagErr = errorQueue.peek();
    	        	String tagExt = extrasQueue.peek();
    	        	if(tagErr.equals(tagExt)) {
    	        		errorQueue.dequeue();
    	        		extrasQueue.dequeue();
    	        	}else {
    	        		 System.out.println("Error: " + errorQueue.dequeue());
    	        	}
    	        }
    		 
    	
    }}
  
	private boolean isSelfClosingTag(String line) {
    	if(line.startsWith("<") && line.endsWith("/>")) return true;

		return false;
    	
    }
	
	private boolean isOpeningTag(String line) {
		return line.startsWith("<") && line.endsWith(">") && !line.startsWith("</") && !line.endsWith("/>");
    	
    }
	
    private boolean isClosingTag(String tag) {
    	if(tag.startsWith("</") && tag.endsWith(">")) return true;
		return false;
    }
    
    
  public String extractTagName(String line) {
	  line = line.trim();
	  String[] tags = line.split(" ");
	  String extractTag = tags[0];
	  if(isSelfClosingTag(line)) return "";
	  if(line.startsWith("<?")) return "";
	  if(isOpeningTag(line) && tags.length>1) {
			  extractTag = extractTag+ ">" ;
			  return extractTag;
		  }
	  
		  if(isClosingTag(line)) {
			  return extractTag;
		  }
	return extractTag; 
  }
	
	

	public static void main(String[] args) {
		XMLParser parser = new XMLParser();
		try {
			parser.parse("res/sample1.xml");
			parser.reportError();
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
