package net.mcorp.modder.urls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * <h1>net.mcorp.modder.urls.URLS</h1>
 * <hr>
 * <p>
 * 	This class is used to store a collection of URL's.
 * </p>
 * @author Andrew Kerr
 */
public class URLS {
	
	protected final ArrayList<URL> urls = new ArrayList<URL>();
	
	private Exception exception;
	public Exception exception() { return this.exception; };
	protected void raiseException(Exception e) { this.exception = e; };
	
	/**
	 * Constructs a new URLS object with no pre-loaded urls.
	 */
	public URLS() {}
	
	/**
	 * This constructor will attempt to read in the url's stored in the provided file. If the file
	 * does not exist then nothing will be read in, leaving the list empty. However the {@linkplain URLS#exception()}
	 * method will contain a {@linkplain FileNotFoundException}. Any url that is read in will be added unless that url
	 * results in a {@linkplain MalformedURLException} then it will not be added.
	 * @param file - {@linkplain File} - A file containing url's separated by a newline character.
	 * @implNote The provided file must be of extension ".urls".
	 */
	public URLS(File file) {
		if(file == null || file.exists() == false) {
			this.raiseException(new FileNotFoundException("Thrown due to a missing file provided at construction."));
		}else {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				String line;
				while((line = br.readLine()) != null) {
					try {
						this.urls.add(new URL(line));
					}catch(Exception e) {}
				}
				
				br.close();
			}catch(Exception e) {
				this.raiseException(e);
			}
		}
	}
	
	/**
	 * Attempts to add the provided url parameter.
	 * @param url - {@linkplain URL} - The url to add.
	 * @return {@linkplain Boolean} - True if the element was added or was already in the list otherwise false.
	 */
	public final boolean add(URL url) {
		if(this.contains(url))
			return true;
		return this.urls.add(url);
	}
	
	/**
	 * Attempts to remove the provided url parameter.
	 * @param url - {@linkplain URL} - The url to remove.
	 * @return {@linkplain Boolean} - True if the element was removed or was not found in the list otherwise false.
	 */
	public final boolean remove(URL url) {
		if(this.contains(url))
			return true;
		return this.urls.remove(url);
	}
	
	/**
	 * Checks to see if the url provided exists in this list.
	 * @param url - {@linkplain URL} - The url to check for.
	 * @return {@linkplain Boolean} - True if the url was found otherwise False.
	 */
	public final boolean contains(URL url) {
		if(this.urls.contains(url))
			return true;
		for(URL url_ : urls) {
			if(url_.equals(url) || url_.sameFile(url))
				return true;
		}
		return false;
	}
	
	/**
	 * Returns the URL located at the index, any number above the result of {@linkplain #length()} method will wrap back to 0.
	 * Any number lower than 0 will throw a {@linkplain IndexOutOfBoundsException}.
	 * @param index - {@linkplain Integer} - The index of the desired url.
	 * @return {@linkplain URL} - The URL located at the index.
	 * @throws IndexOutOfBoundsException Thrown if the index is lower than 0.
	 */
	public final URL url(int index) {
		return this.urls.get(index % this.urls.size());
	};
	
	/**
	 * Returns the length of the URL list.
	 * @return {@linkplain Integer} - The number of stored URL's.
	 */
	public final int length() {
		return this.urls.size();
	}
	
	/**
	 * Returns an array of the stored url's.
	 * @return {@linkplain URL}[] - An array of url's.
	 */
	public final URL[] urls() {
		return this.urls.toArray(new URL[] {});
	}
	
}
