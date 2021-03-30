const txtFechNac = document.getElementById('txtFechNac');
const datepicker = new Datepicker(txtFechNac, {
  buttonClass: 'btn',
  language: 'es',
  format: 'yyyy/mm/dd',
  autohide: true
});
