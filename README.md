# netart.today

Net Art as it appears today

## To Run

`clj -m core > index.html`

## Data Structure

The artworks listed are held under `resources/art.edn`. Each artwork contains several data points. To get a sense of the data, it may be easier to look at this [spreadsheet](https://airtable.com/shrhfvcQCI9R30J5F/tbl9PWDyk2nyBLy7R). Here are the details:

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
        1. the **link-from** website will function
        2. the artwork **url** on the website will no longer function as intended.
    - **link-from-url**: the url of the website where the original artwork's **url** was found
- Archive details
    - **current-archive**: if the artwork has been moved or archived in a publicly available site, this is the name of the site.
    - **current-archive-url**: the url of the **current-archive** where the artwork is publicly available and running today.
