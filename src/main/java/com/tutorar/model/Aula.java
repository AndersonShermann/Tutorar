package com.tutorar.model;


import java.sql.Time;
import java.time.format.DateTimeFormatter;
import com.tutorar.enums.Categoria_aula;
import com.tutorar.enums.Plataforma_aula;
import com.tutorar.enums.Tipo_aula;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Aula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String hr_aula;
	
	@Column
	private float vl_aula;
	
	@Column
	private Date dt_aula;
	
	@Column(nullable = false)
	private String nome_disciplina;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Categoria_aula categoria;
	
	@Column
	private String descricao;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipo_aula tipo_aula;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Plataforma_aula plataforma;

	@OneToMany
    @JoinColumn(name="aula_id")
	private List<Usuario> usuario;
	
	@ManyToOne
	@JoinColumn(name="professor_id")
	private Professor professor;

	
	//construtors

	public Aula( int id, String hr_aula, float vl_aula, Date dt_aula, String nome_disciplina, 
Categoria_aula categoria, String descricao, Tipo_aula tipo_aula, Plataforma_aula plataforma) {
		super();
		this.id = id;
		this.hr_aula = hr_aula;
		this.vl_aula = vl_aula;
		this.dt_aula = dt_aula;
		this.nome_disciplina = nome_disciplina;
		this.categoria = categoria;
		this.descricao = descricao;
		this.tipo_aula = tipo_aula;
		this.plataforma = plataforma;
	}
	
	public Aula() {
		
	}
	
	//getters e setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHr_aula() {
		return hr_aula;
	}

	public void setHr_aula(String hr_aula) {
		this.hr_aula = hr_aula;
	}

	public float getVl_aula() {
		return vl_aula;
	}

	public void setVl_aula(float vl_aula) {
		this.vl_aula = vl_aula;
	}

	public Date getDt_aula() {
		return dt_aula;
	}

	public void setDt_aula(Date dt_aula) {
		this.dt_aula = dt_aula;
	}

	public String getNome_disciplina() {
		return nome_disciplina;
	}

	public void setNome_disciplina(String nome_disciplina) {
		this.nome_disciplina = nome_disciplina;
	}

	public Categoria_aula getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria_aula categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Tipo_aula getTipo_aula() {
		return tipo_aula;
	}

	public void setTipo_aula(Tipo_aula tipo_aula) {
		this.tipo_aula = tipo_aula;
	}

	public Plataforma_aula getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma_aula plataforma) {
		this.plataforma = plataforma;
	}
	
	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Aula [id=" + id + ", hr_aula=" + hr_aula + ", vl_aula=" + vl_aula + ", dt_aula=" + dt_aula
				+ ", nome_disciplina=" + nome_disciplina + ", categoria=" + categoria + ", descricao=" + descricao
				+ ", tipo_aula=" + tipo_aula + ", plataforma=" + plataforma + "]";
	}
	
	
}
