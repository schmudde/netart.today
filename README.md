# Gallery 404

The net.art Gallery at [netart.today](http://www.netart.today/).

## About

Digital artifacts are trivial to copy but very difficult to preserve. This gallery highlights over twenty years of misplaced and broken works of art. [Net.art](https://en.wikipedia.org/wiki/Net.art) embodies the work of a generation of internet pioneers and much of it has already been lost to time.

## To Run

`clj -m core`

## Submissions

Pull requests are welcome! If you found a corner of the internet that was once dedicated to a work of net/digital/telematic art, please make a submission or eMail me. My contact information is [here](https://schmud.de/pages/about.html).

To maintain the integrity of the gallery, the submission modest requirements are somewhat strict. Please attempt to fill out as many data points as possible. The format is available under `resources/art.edn` - also available as a [spreadsheet](https://airtable.com/shrhfvcQCI9R30J5F/tbl9PWDyk2nyBLy7R) if you think it is more readable.

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

## External Dependencies

Goat Counter

## Further Reading

- Berry, David M. "[The Post-Archival Constellation: The Archive under the Technical Conditions of Computational Media](https://doi.org/10.2307/j.ctt1jd94f0.8)". *Memory In Motion*, 2017, 103-126. doi:10.2307/j.ctt1jd94f0.8.
- Connor, Michael J, Aria Dean, and Dragan Espenshied. *[The Art Happens Here: Net Art Anthology](https://rhizomedotorg.myshopify.com/products/the-art-happens-here-net-art-anthology)*, 2019.
- Kraynak, Janet. *[Contemporary Art and the Digitization of Everyday Life](https://www.ucpress.edu/book/9780520303911/contemporary-art-and-the-digitization-of-everyday-life)*. University of California Press, 2020.
- Collections
    - Grau, Oliver, Janina Hoth, and Eveline Wandl-Vogt. *Digital Art Through the Looking Glass: New Strategies For Archiving, Collecting and Preserving in Digital Humanities*. Austrian Academy of Sciences Press, 2019.
    - Baas, Jacquelynn. *Buddha Mind In Contemporary Art*. Berkeley, CA: University of California Press, 2004.

## Resources

### Research Groups

- [History of Creative Coding](https://groups.google.com/g/history-of-creative-coding)
- [Artists and Hackers Podcast](https://www.artistsandhackers.org/about.html)

### Digital Archives

- Individual curation
    - [Conifer](https://conifer.rhizome.org/) #host
    - [The Recode Project](http://www.recodeproject.com/) #host, #link
    - [Monoskop](https://monoskop.org/Monoskop) #host
    - [archive.today](http://archive.today/) #host
- Institutional curation
    - [Rhizome](https://rhizome.org/) #host, #link
    - [Digital Art Archive](https://www.digitalartarchive.at/nc/home.html) #link
    - [Turbulence](http://turbulence.org/): Commissioning and supporting net, web, hybrid art since 1996 (on [GitHub](https://github.com/turbulence-org))
    - [Post-Digital Publishing Archive](http://p-dpa.net/)
    - [V2_Lab for the Unstable Media Archive](https://v2.nl/archive/latest-added-works) #link
- Indiscriminate curation
    - [Internet Archive](https://archive.org) #host

Archives that feature the artwork often #link to the work rather than #host it. These links fall into four categories.

1. There may be no link to the original work.
2. There may be a link to the original work which is no longer hosted at the domain.
3. There may be a link to the original work which is still hosted at the domain, but the artwork no longer works (e.g. [1+1](https://www.digitalartarchive.at/database/general/work/1-1.html) on the Digital Art Archive))
4. There may be a valid link to the original work.

There are also interesting opportunities emerging on IPFS. For example, [The Hampster Dance](https://ipfs.io/ipfs/QmT85wMjWsywH6K6dQFZz7q93SYiVpDp5y8LEapp42kvHj/).

### Mainstream Reporting on Digital Art Preservation

- "[When Artworks Crash: Restorers Face Digital Test](https://www.nytimes.com/2013/06/10/arts/design/whitney-saves-douglas-daviss-first-collaborative-sentence.html)", *New York Times* (2013)

# TODO

- Copy edit each artwork caption
- Add [*This and that thought.*](http://turbulence.org/project/this-and-that-thought/) (requires Flash)
- Add the gift shop and publications.
    - [Douglas Davis:
The World's First Collaborative Sentence](https://whitney.org/artport/douglas-davis)
        - [How to Join in Making the World's First Collaborative Sentence](https://artport.whitney.org/collection/DouglasDavis/live/writesentence.html)
        - [sentence](https://artport.whitney.org/collection/DouglasDavis/live/Sentence/sentence1.html)
    - [The Art of Unix Programming](https://www.arp242.net/the-art-of-unix-programming/)
