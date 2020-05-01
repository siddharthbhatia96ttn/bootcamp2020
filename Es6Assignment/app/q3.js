//Q3. Create a markup template using string literal
const song = {
 name: 'Dying to live',
 artist: 'Tupac',
 featuring: 'Biggie Smalls'
};

const output=`
<div class="song">
<p>
${song.name}-${song.artist}
(Featuring ${song.featuring})
</p>
<div>
`
document.body.innerHTML = output;

export { output };
