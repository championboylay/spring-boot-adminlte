package com.hendisantika.adminlte.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "eventoutlet")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"memberList","outlet"})
public class EventOutlet implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="outlet_id")
	private OutletSetUp outlet = new OutletSetUp();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="event_outlet")
	private List<EventMember> memberList = new ArrayList<EventMember> ();
	
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private Event event;
	
	
	@Embedded
	private AbstractTimeStamp timeStamp = new AbstractTimeStamp();
	
	@Version
	@Column(name = "version")
	private long version;
}
