package it.polito.tdp.genes.model;

public class Genes {
	
	private String geneId;
	private String essential;
	private int chromosome;
	
	public Genes(String geneId, String essential, int chromosome) {
		super();
		this.geneId = geneId;
		this.essential = essential;
		this.chromosome = chromosome;
	}

	public String getGeneId() {
		return geneId;
	}



/*SELECT c.GeneID
FROM classification c
WHERE localization="golgi"







SELECT i.GeneID1, i.GeneID2, i.`Type`
FROM interactions i
WHERE i.GeneID1="G234064" AND i.GeneID2="G234126"
OR i.GeneID2="G234064" AND i.GeneID1="G234126"*/
	
	
//	SELECT distinct type
//	FROM (SELECT c.localization AS Localization1, c2.Localization AS Localization2,
//	 c.GeneID AS Gene1, c2.GeneID AS Gene2, i.`Type`
//	FROM classification c, classification c2, interactions i
//	WHERE c.Localization="cytoplasm" AND c2.Localization="cytoskeleton" AND((i.GeneID1=c.GeneID AND i.GeneID2=c2.GeneID) OR 
//	(i.GeneID1=c2.GeneID AND i.GeneID2=c.GeneID))
//	GROUP BY c.Localization, c2.Localization, c.GeneID, c2.GeneID
//	ORDER BY 'Gene2') AS a2

	public void setGeneId(String geneId) {
		this.geneId = geneId;
	}

	public String getEssential() {
		return essential;
	}

	public void setEssential(String essential) {
		this.essential = essential;
	}

	public int getChromosome() {
		return chromosome;
	}

	public void setChromosome(int chromosome) {
		this.chromosome = chromosome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geneId == null) ? 0 : geneId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genes other = (Genes) obj;
		if (geneId == null) {
			if (other.geneId != null)
				return false;
		} else if (!geneId.equals(other.geneId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.geneId;
	}


	
	

}
