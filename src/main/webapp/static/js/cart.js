const AddToCart = document.querySelector('#addProduct')


const product = AddToCart.dataset.id
console.log(product)

// const getProductId = async () => {
//     const response = await fetch('/cart/add?prod_name=' + product);
//     return await response.json()
// };
async function addItemToCart(event){
    fetch('/cart/add?prod_name=' +event.target.dataset.id)
}