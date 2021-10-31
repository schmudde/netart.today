# Gallery 404

[Gallery 404](http://www.netart.today/), exhibits net.art as it appears today - exclusively specializing in broken artworks, launched Nov 2020, run by David Schmudde. (Description via [Monoskop](https://monoskop.org/Net_art))

## About

Digital artifacts are trivial to copy but very difficult to preserve. This gallery highlights over twenty years of misplaced and broken works of art. [net.art](https://en.wikipedia.org/wiki/Net.art) embodies the work of a generation of internet pioneers and much of it has already been lost to time.

Read more about the gallery, net.art, and the historical context at Gallery 404's [about page](http://www.netart.today/pages/about.html).

# Running

## To Run

`clj -m core`

## External Dependencies

Goat Counter

# Curatorial Statement

[Dejan Grba](http://dejangrba.org/), the artist behind one of my favorite works, *[All My People Right Here Right Now](http://dejangrba.org/art-projects/en/2003-all-my-people/index.html)*, asked this question as part of xCoAx 2021's [Artists' Roundtable](https://2021.xcoax.org/artworks2/):

> Browsing through the complete Gallery 404, it is surprising that you haven't included more dysfunctional/inaccessible net.art projects. Is there a specific selective criterion that you apply or is it because you have just started?

I started Gallery 404 because I was frustrated by all the broken hyperlinks I found when doing research for my talk "[Software Preservation in Networked Art](https://nexa.polito.it/mercoledi-133)". I then rounded out the dataset by including non-working works from the [Archive of Digital Art](https://www.digitalartarchive.at/database/general/work/1-1.html).

## Submissions

Pull requests are welcome! If you find a place on the internet that holds net.art debris, please make a submission or eMail me. Formal submission requirements are below. If that's too intimidating, please simply eMail me. My contact information is [here](https://schmud.de/pages/about.html).

To maintain the integrity of the gallery, I do ask you to fill in as many requisite data points as possible. The format is available under `resources/art.edn` - also available as a [spreadsheet](https://airtable.com/shrhfvcQCI9R30J5F/tbl9PWDyk2nyBLy7R) if you think it is more readable.

Here is the explanation of each data point:

- Artwork details
    - **title**: the title of the net.art artwork or gallery
    - **url**: the original URL of the artwork
    - **artist**: the artist(s), curator(s), or group that produced the net.art artwork or gallery space
    - **date**: the date or date range the artwork was made
    - **desc**: description of the artwork
    - **desc-source**: a link to the source of the artwork's **desc**
- Domain details
    - **retrieved**: the date when `netart.today` last visited the artwork's original **url**. In year-month-day (`yyyy-mm-dd`) format
    - **image**: a screen capture of the artwork's original **url** when it was last **retrieved**
        - The format is `artwork-title-yyyymmdd-width-height.png`.
        - The resolution of the image should be `1920x1055`.
    - **link-from**: the website where the original artwork's **url** was found. On the date when the website was **retrieved**:
        - the **link-from** website will function
        - the artwork **url** on the website will no longer function as intended.
    - **link-from-url**: the url of the website where the original artwork's **url** was found
- Archive details
    - **current-archive**: if the artwork has been moved or archived in a publicly available site, this is the name of the site.
    - **current-archive-url**: the url of the **current-archive** where the artwork is publicly available and running today.

# Resources

## Further Reading

- Berry, David M. "[The Post-Archival Constellation: The Archive under the Technical Conditions of Computational Media](https://doi.org/10.2307/j.ctt1jd94f0.8)". *Memory In Motion*, 2017, 103-126. doi:10.2307/j.ctt1jd94f0.8.
- Connor, Michael J, Aria Dean, and Dragan Espenshied. *[The Art Happens Here: Net Art Anthology](https://rhizomedotorg.myshopify.com/products/the-art-happens-here-net-art-anthology)*, 2019.
- Kraynak, Janet. *[Contemporary Art and the Digitization of Everyday Life](https://www.ucpress.edu/book/9780520303911/contemporary-art-and-the-digitization-of-everyday-life)*. University of California Press, 2020.
- Collections
    - Grau, Oliver, Janina Hoth, and Eveline Wandl-Vogt. *Digital Art Through the Looking Glass: New Strategies For Archiving, Collecting and Preserving in Digital Humanities*. Austrian Academy of Sciences Press, 2019.
    - Baas, Jacquelynn. *Buddha Mind In Contemporary Art*. Berkeley, CA: University of California Press, 2004.

## Research Groups

- [History of Creative Coding](https://groups.google.com/g/history-of-creative-coding)
- [Artists and Hackers Podcast](https://www.artistsandhackers.org/about.html)

## Digital Archives

- Individual curation
    - [Conifer](https://conifer.rhizome.org/) #host
    - [The Recode Project](http://www.recodeproject.com/) #host, #link
    - [Monoskop](https://monoskop.org/Monoskop) #host
    - [archive.today](http://archive.today/) #host
    - GitHub is a #host to many gems, such as runnable Csound versions of Richard Boulanger's “[Trapped in Convert](https://github.com/csound/csound/blob/develop/examples/trapped.csd)” (1979/1997), Joeseph T Kung's “[Xanadu](https://github.com/csound/csound/blob/develop/examples/xanadu.csd)” (1988), and Jean-Claude Risset's [orchestras and scores](https://github.com/csound/csound/blob/develop/examples/xanadu.csd) ported from Music V (1969-1982).
- Institutional curation
    - [Rhizome](https://rhizome.org/) #host, #link
    - [Digital Art Archive](https://www.digitalartarchive.at/nc/home.html) #link
    - [Turbulence](http://turbulence.org/): Commissioning and supporting net, web, hybrid art since 1996 (on [GitHub](https://github.com/turbulence-org))
    - [Post-Digital Publishing Archive](http://p-dpa.net/)
    - [V2_Lab for the Unstable Media Archive](https://v2.nl/archive/latest-added-works) #link
    - [Digital Museum of Digital Art](https://dimoda.art/)
- Indiscriminate curation
    - [Internet Archive](https://archive.org) #host

Archives that feature the artwork often #link to the work rather than #host it. These links fall into four categories.

1. There may be no link to the original work.
2. There may be a link to the original work which is no longer hosted at the domain.
3. There may be a link to the original work which is still hosted at the domain, but the artwork no longer works (e.g. [1+1](https://www.digitalartarchive.at/database/general/work/1-1.html) on the Digital Art Archive))
4. There may be a valid link to the original work.

There are also interesting opportunities emerging on IPFS. For example, [The Hampster Dance](https://ipfs.io/ipfs/QmT85wMjWsywH6K6dQFZz7q93SYiVpDp5y8LEapp42kvHj/). Monoskop also hosts [a list of archives](https://monoskop.org/Net_art).

## Mainstream Reporting on Digital Art Preservation

- "[When Artworks Crash: Restorers Face Digital Test](https://www.nytimes.com/2013/06/10/arts/design/whitney-saves-douglas-daviss-first-collaborative-sentence.html)", *New York Times* (2013)
- "[Holding Onto Our History](https://thehistoryoftheweb.com/postscript/april-2021-weblog-holding-on-to-our-history/)", *The History of the Web* (2021)

## Meta-Preservation

- William Gibson’s [*Agrippa*](https://arstechnica.com/information-technology/2012/07/william-gibsons-agrippa-mystery-challenge/)
- [*The Gallery of Lost Art*](http://galleryoflostart.com/) at the Tate. &lsquo;on July 1, 2013, exactly a year after its launch, the Gallery of Lost Art will cease to exist. To some, literally pulling the plug on this skillfully designed and rigorously researched educational resource is heartbreaking. Renaissance scholar David Rundle described Mundy’s decision to forever delete the Gallery of Lost Art as an act of “creative vandalism.”&rsquo; ~ [The Brooklyn Rail](https://brooklynrail.org/2013/06/artseen/tate-gallerythe-gallery-of-lost-art)

## Preservation Organizations

- [Web Design Museum](https://www.webdesignmuseum.org/)
- [Small Data Industries](https://smalldata.industries/) by Ben Fino-Radin
- [Anarchivism](https://anarchivism.org/w/Main_Page)
- [V2_](https://v2.nl/)

# Keywords

- Keywords: fine art, internet history, net art, art preservation, telematic art
- [Long tail keywords](https://keywordtool.io/): net art anthology, what is net art, what is net art, when did net.art begin, net artist, net art definition, net art examples, net art artists, net art exhibition

# TODO

- Copy edit each artwork caption
- Add footer link to home and index (utility links), add index, and add exhibit numbers for each artwork (e.g. 3/31, 4/31, etc...)
- Add the gift shop and publications.
    - [Douglas Davis:
The World's First Collaborative Sentence](https://whitney.org/artport/douglas-davis)
        - [How to Join in Making the World's First Collaborative Sentence](https://artport.whitney.org/collection/DouglasDavis/live/writesentence.html)
        - [sentence](https://artport.whitney.org/collection/DouglasDavis/live/Sentence/sentence1.html)
    - [The Art of Unix Programming](https://www.arp242.net/the-art-of-unix-programming/)
    - [Fix My Code](https://eeclectic.de/produkt/fix-my-code/)
    - Gallery 404 is making a statement about digital objects and their value. It clearly states that we are not taking the preservation of digital culture seriously enough. A more subtle observation is that digital culture that is not free (as in libre, not as in beer) decays faster. The most prominent example are creative works done in non-free technologies like Flash. Gallery 404 exhibits many of these. The shop should re-enforce these concepts so Gallery 404 can be a complete artwork.
        - What will be the focus?
        - I can also see room for inexpensive/free digital objects. Perhaps a self-erasing software notebook?
- Automate gallery announcements (i.e. Today marks a new addition to Gallery 404's illustrious collection of broken net art. "This and that thought." by BFFA3AE via @turbulenceorg. http://www.netart.today/)
- Consider collections
    - [Works of net.art](http://www.hgb-leipzig.de/artnine/netzkunst/werke.html)
    - [Turbulence](http://turbulence.org/)
- `edn` improvements
    - Add `:date` metadata
    - List artists in vector
- A collection of artworks that continue to work, in spite of changes in the environment. For example, Heath Bunting's *[Own, Be Owned Or Remain Invisible.](http://irational.org/_readme.html)*.
