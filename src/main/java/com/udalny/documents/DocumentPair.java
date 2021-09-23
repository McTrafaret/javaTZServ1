package com.udalny.documents;

public class DocumentPair
{
	private Report report;
	private PayDocs paydocs;
	private static final String castError = "One of the documents is not valid PayDocs or Report document.";

	public DocumentPair(ServerDocument a, ServerDocument b)
		throws ClassCastException
	{
		if(a instanceof Report)
		{
			report = (Report) a;
			if(b instanceof PayDocs)
			{
				paydocs = (PayDocs) b;
			}
			else
			{
				throw new ClassCastException(castError);
			}
		}
		else if(a instanceof PayDocs)
		{
			paydocs = (PayDocs) a;
			if(b instanceof Report)
			{
				report = (Report) b;
			}
			else
			{
				throw new ClassCastException(castError);
			}
		}
		else
		{
			throw new ClassCastException(castError);
		}
	}

	public DocumentPair(Report report, PayDocs paydocs)
	{
		this.report = report;
		this.paydocs = paydocs;
	}

    public Report getReport() {
        return report;
    }

    public PayDocs getPaydocs() {
        return paydocs;
    }
}
