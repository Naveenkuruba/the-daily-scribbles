package thedailyscribbles.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import thedailyscribbles.model.Admin;
import thedailyscribbles.model.Blogger;
import thedailyscribbles.model.Comment;
import thedailyscribbles.model.Community;
import thedailyscribbles.model.Post;
import thedailyscribbles.service.TempServ;

@RestController
public class TrialController {
	@Autowired
	TempServ ts;
	
	@GetMapping("/adduser")
	public void createUser() {
		Admin usr = new Admin("12345678","puthin","contact");
		//ts.createUser(usr);
	}
	
	@GetMapping("/blogger")
	public void createBlogger() {
		Blogger b = new Blogger("324234234324234","Kumar",56);
		List<Post> postList = new ArrayList<Post>();
		Post p1 = new Post("morning","Good mornign");
		Post p2 = new Post("what's up?","what is going on?");
		postList.add(p1);
		p1.setBlogOwner(b);
		postList.add(p2);
		p2.setBlogOwner(b);
		b.setPost(postList);
		
		List<Comment> commentList = new ArrayList<>();
		Comment c1 = new Comment("this is good stuff",b,p1);
		Comment c2 = new Comment("dude that sucks",b,p2);
		
		commentList.add(c1);
		commentList.add(c2);
		
		b.setComments(commentList);
		
		List<Post> upVoted = new ArrayList<>();
		List<Post> downVoted = new ArrayList<>();
		
		List<Blogger> upVoters = new ArrayList<>();
		List<Blogger> downVoters = new ArrayList<>();
		Blogger b2 = new Blogger("4545454545","Sammy",56);
		upVoters.add(b);
		downVoters.add(b2);
		p1.setBlogUpVoters(upVoters);
		p1.setBlogDownVoters(downVoters);
		
		downVoters.remove(0);
		downVoters.add(b);
		p2.setBlogDownVoters(downVoters);
		
		upVoted.add(p1);
		downVoted.add(p2);
		
		b.setUpVoted(upVoted);
		b.setDownVoted(downVoted);
		
		List<Community> communityList = new ArrayList<>();
		Community cm1 = new Community("wassup","sex");
		Community cm2 = new Community("bitch","city");
		
		List<Blogger> members = new ArrayList<>();
		members.add(b);
		members.add(b2);
		
		cm1.setMembers(members);
		cm2.setMembers(members);
		
		communityList.add(cm1);
		communityList.add(cm2);
		
		b.setCommunities(communityList);
		
		ts.createUser(b);
	}
}