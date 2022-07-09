package it.polito.tdp.genes.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import it.polito.tdp.genes.db.GenesDao;

public class Model {

	private GenesDao dao;
	private SimpleWeightedGraph<String,DefaultWeightedEdge> grafo;
	private List<String> vertici;
	private List<Coppia> archi;

	public Model() {
		dao=new GenesDao();
	}
	public void creaGrafo() {
		this.grafo=new SimpleWeightedGraph<String,DefaultWeightedEdge>(DefaultWeightedEdge.class);
		vertici=new ArrayList<String>(dao.getAllLocalizations());
		Graphs.addAllVertices(this.grafo,vertici);
		
		
		for(String a: vertici) {
			for(String b:vertici) {
				if(!a.equals(b)) {
					if(dao.getArchi(a, b)>0)
						Graphs.addEdge(this.grafo, a, b, dao.getArchi(a, b));
					
					
				}
			}
		}
		System.out.println(this.grafo.vertexSet().size());
		System.out.println(this.grafo.edgeSet().size());

		
		
	}
	public Set<String> getArchi() {
		if(this.grafo==null) {
			return null;
		}
		return this.grafo.vertexSet();
	}
	
	public Set<Vicino> getComponenteConnessa(String vertice) {
		Set<String> vicini=new HashSet<>(Graphs.neighborListOf(this.grafo, vertice));
		Set<Vicino> viciniPesi=new HashSet<>();
		for(String s: vicini) {
			double peso= this.grafo.getEdgeWeight(this.grafo.getEdge(vertice, s));
			Vicino v=new Vicino (s,peso);
			viciniPesi.add(v);
			
		}
		
		return viciniPesi;
	}

}