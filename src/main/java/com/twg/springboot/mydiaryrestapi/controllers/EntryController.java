package com.twg.springboot.mydiaryrestapi.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twg.springboot.mydiaryrestapi.entities.Entry;
import com.twg.springboot.mydiaryrestapi.service.EntryService;

@RestController
public class EntryController {
    
	@Autowired
	private EntryService entryService;
	
	@GetMapping("/entries/")
	public List<Entry> findAllEntries(){
		
		List<Entry> entrieslist=entryService.findAll();
		
		return entrieslist;
		
	}
	@PostMapping("/entries/")
	public Entry saveentry(@RequestBody Entry entry) 
	{
		
		Entry savedentry=entryService.saveEntry(entry);
		return savedentry;
	}
	@PutMapping("/entries/")
	public Entry updateEntry(@RequestBody Entry entry) 
	{
		
		Entry updatedentry=entryService.updateEntry(entry);
		return updatedentry;
	}
	
	@GetMapping("/entries/{id}")
	public Entry getEntry(@PathVariable("id") int id)
	{
		Entry entry=entryService.findById(id);
		return entry;
	}
	@DeleteMapping("/entries/{id}")
	public void deleteEntry(@PathVariable int id)
	{
		Entry entry=entryService.findById(id);
		entryService.deleteEntry(entry);
	}
	@PutMapping("/entries/{id}")
	public void updateEntry1(@RequestBody Entry entry,@PathVariable("id") int id)
	{
		Entry entry1=entryService.findById(id);
		entry1.setDescription(entry.getDescription());
		entry1.setEntrydate(entry.getEntrydate());
		entry1.setUserid(entry.getUserid());
		entryService.updateEntry(entry1);
	}
	@PatchMapping("/entries/{id}")
	public Entry updateEntry2(@RequestBody Entry entry,@PathVariable int id)
	{
		
		Entry entry2=entryService.findById(id);
		String des=entry.getDescription();
		Date dt=entry.getEntrydate();
		long userid=entry.getUserid();
		
		if(des!=null && des.length()>0)
		{
			entry2.setDescription(des);
		}
		if(dt!=null)
		{
			entry2.setEntrydate(dt);
		}
		if(userid>0)
		{
			entry2.setUserid(userid);
		}
		Entry entry4=entryService.updateEntry(entry2);
		return entry4;
	}
}
