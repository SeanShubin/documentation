# CSS Tips

## Determine size relative to border

    * {
        box-sizing: border-box;
    }

## Use css resets

For example, here is the [meyerweb](https://meyerweb.com/eric/tools/css/reset/reset200802.css) reset

    /* http://meyerweb.com/eric/tools/css/reset/ */
    /* v1.0 | 20080212 */
    
    html, body, div, span, applet, object, iframe,
    h1, h2, h3, h4, h5, h6, p, blockquote, pre,
    a, abbr, acronym, address, big, cite, code,
    del, dfn, em, font, img, ins, kbd, q, s, samp,
    small, strike, strong, sub, sup, tt, var,
    b, u, i, center,
    dl, dt, dd, ol, ul, li,
    fieldset, form, label, legend,
    table, caption, tbody, tfoot, thead, tr, th, td {
        margin: 0;
        padding: 0;
        border: 0;
        outline: 0;
        font-size: 100%;
        vertical-align: baseline;
        background: transparent;
    }
    body {
        line-height: 1;
    }
    ol, ul {
        list-style: none;
    }
    blockquote, q {
        quotes: none;
    }
    blockquote:before, blockquote:after,
    q:before, q:after {
        content: '';
        content: none;
    }
    
    /* remember to define focus styles! */
    :focus {
        outline: 0;
    }
    
    /* remember to highlight inserts somehow! */
    ins {
        text-decoration: none;
    }
    del {
        text-decoration: line-through;
    }
    
    /* tables still need 'cellspacing="0"' in the markup */
    table {
        border-collapse: collapse;
        border-spacing: 0;
    }

## Use clearfix

## Use transform scale for debugging

    body {
        margin: 0;
        padding: 0;
        transform: scale(0.9);
        border: thin solid black;
    }
