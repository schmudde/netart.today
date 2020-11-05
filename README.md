# netart.today

Net Art as it appears today

## To Run

`clj -m core > index.html`

## Data Structure

The artworks listed are held under `resources/art.edn`. Each artwork contains several data points. To get a sense of the data, it may be easier to look at this [spreadsheet](https://airtable.com/shrhfvcQCI9R30J5F/tbl9PWDyk2nyBLy7R). Here are the details:

- Artwork details
    - **title**: the title of the net.art artwork or gallery
    - **url**: the original URL of the artwork
    - **artist**: the artist, artists, or group that made the artwork
    - **date**: the date or date range the artwork was made
    - **desc**: description of the artwork
    - **desc-source**: a link to the source of the artwork's **desc**
- Domain details
    - **retrieved**: the date when `netart.today` last visited the artwork's original **url**. In year-month-day (`yyyy-mm-dd`) format
    - **image**: a screen capture of the artwork's original **url** when it was last **retrieved**.The format is `artwork-title-yyyymmdd-width-height.png`
    - **link-from**: the website where the original artwork's **url** was found. In all cases, on the date when the website was **retrieved**, the website will be live, but the artwork will have bene lost
    - **link-from-url**: the url of the website where the original artwork's **url** was found
- Archive details
    - **current-archive**: if the artwork has been moved or archived in a publicly available site, this is the name of the site.
    - **current-archive-url**: the url of the **current-archive** where the artwork is publicy available and runing today.
